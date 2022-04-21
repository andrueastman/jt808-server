var $ = function(id) {
    return document.getElementById(id);
};
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
var axios = {
    /**
     * jsEncapsulate ajax request
     * >>Use new XMLHttpRequest to create a request object, so low-end IE browsers are not considered (IE6 and below do not support XMLHttpRequest)
     * >>Use es 6 syntax, if you need to use it in a formal environment, you can use babel to convert to es 5 syntax https://babeljs.cn/docs/setup/#installation
     *  @param option Request parameters mimic jQuery ajax
     *  To call this method, the data parameter needs to correspond to the request header Content-Type
     *  Content-Type                        data                                     description
     *  application/x-www-form-urlencoded   'name=haHa&age=12'or{name:'haHa',age:12}  Query string, split with &
     *  application/json                     name=haHa&age=12'                        json string
     *  multipart/form-data                  new FormData()                           Form Data object, when it is Form Data type, do not manually set Content-Type
     *  Note: If the request parameter contains a date type. Whether the request can be successful requires the cooperation of the background interface
     */
    request: (option = {}) => {
    // Initialize request parameters
    let defaultOption = Object.assign({
        url: '', // string
        type: 'GET', // string 'GET' 'POST' 'DELETE'
        dataType: 'json', // string Expected return data type:'json' 'text' 'document' ...
        async: true, //  boolean true:asynchronous request false: synchronous requestasynchronous request false: synchronous request required
        data: {}, // any Request parameters, data needs to correspond to the request header Content-Type
        headers: {}, // request header
        timeout: 1000, // string Timeout time: 0 means no timeout is set
        beforeSend: function(xhr) {},
        success: function(result, status, xhr) {},
        error: function(xhr, status, error) {},
        complete: function(xhr, status) {}
    }, option);
// parameter validation
// defaultOption.headers['Origin'] = '*'
if (defaultOption.dataType === 'json') {
    defaultOption.headers['Content-Type'] = 'application/json'
}
if (!defaultOption.url || !defaultOption.type || !defaultOption.dataType || defaultOption.async === undefined) {
    alert('参数有误');
    return;
}

// Create XML Http Request request object
var xhr = new XMLHttpRequest();
if ('withCredentials' in xhr) {
} else if(typeof XDomainRequest != 'undefined'){
    xhr = new XDomainRequest();
} else {
    alert('不支持[XMLHttpRequest、XDomainRequest]请求！')
    return;
}

// request start callback function
xhr.addEventListener('loadstart', function(e) {
    defaultOption.beforeSend(xhr);
});
// Request success callback function
xhr.addEventListener('load', function(error) {
    const status = xhr.status;
    if ((status >= 200 && status < 300) || status === 304) {
        let result;
        if (xhr.responseType === 'text') {
            result = xhr.responseText;
        } else if (xhr.responseType === 'document') {
            result = xhr.responseXML;
        } else {
            result = xhr.response;
        }
        // Note: The status code 200 indicates that the request is sent and accepted successfully, but does not indicate that the business is processed successfully
        defaultOption.success(result, status, xhr);
    } else {
        defaultOption.error(xhr, status, error);
    }
});
// end of request
xhr.addEventListener('loadend', function(error) {
    defaultOption.complete(xhr, xhr.status);
});
// Error in request
xhr.addEventListener('error', function(error) {
    defaultOption.error(xhr, xhr.status, error);
});
// Request timed out
xhr.addEventListener('timeout', function(error)  {
    defaultOption.error(xhr, 408, error);
});
let param = false;
let methodType = defaultOption.type.toUpperCase();
// If it is a "simple" request, assemble the data parameter on the url
if (methodType === 'GET' || methodType === 'DELETE') {
    param = true;
    defaultOption.url += axios.getUrlParam(defaultOption.url, defaultOption.data);
}
// init request
xhr.open(defaultOption.type, defaultOption.url, defaultOption.async);
// Set the expected return data type
xhr.responseType = defaultOption.dataType;
// set request header
Object.keys(defaultOption.headers).forEach(key => {
    xhr.setRequestHeader(key, defaultOption.headers[key]);
})
// set timeout
if (defaultOption.async && defaultOption.timeout) {
    xhr.timeout = defaultOption.timeout;
}
// Send a request. If it is a simple request, the request parameter should be null. Otherwise, the request parameter type needs to correspond to the request header Content-Type
xhr.send(param ? null : axios.getQueryData(defaultOption.data));
},
// 把参数data转为url查询参数
getUrlParam: (url, data) => {
    if (!data) {
        return '';
    }
    let paramsStr = data instanceof Object ? axios.getQueryString(data) : data;
    return (url.indexOf('?') !== -1) ? paramsStr : '?' + paramsStr;
},
// Get ajax request parameters
getQueryData: (data) => {
    if (!data) {
        return null;
    }
    if (typeof data === 'string') {
        return data;
    }
    if (data instanceof FormData) {
        return data;
    }
    return JSON.stringify(data);
},
// Convert object to query string
getQueryString: (data) => {
    let paramsArr = [];
    if (data instanceof Object) {
        Object.keys(data).forEach(key => {
            let val = data[key];
        // todo 参数Date类型需要根据后台api酌情处理
        if (val instanceof Date) {
            // val = dateFormat(val, 'yyyy-MM-dd hh:mm:ss');
        }
        paramsArr.push(encodeURIComponent(key) + '=' + encodeURIComponent(val));
    });
    }
    return paramsArr.join('&');
}
}