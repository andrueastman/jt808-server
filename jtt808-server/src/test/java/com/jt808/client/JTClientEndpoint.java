package com.jt808.client;

import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.*;
import com.jt808.web.endpoint.JT808Endpoint;
import com.jt808.protocol.t808.T0200;

import java.util.concurrent.atomic.AtomicInteger;

import static com.jt808.protocol.commons.JT808.*;

@Endpoint
public class JTClientEndpoint {

    private static final Logger log = LoggerFactory.getLogger(JT808Endpoint.class.getSimpleName());

    private AtomicInteger serialNo = new AtomicInteger();

    private String mobileNo = "12345678901";

    @Mapping(types = PlatformUniversalResponse, desc = "平台通用应答")
    public void 平台通用应答(T0001 message) {
    }

    @Mapping(types = TheServerRetransmitsTheSubcontractingRequest, desc = "服务器补传分包请求")
    public T0001 服务器补传分包请求(T8003 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryServerTimeResponse, desc = "查询服务器时间应答")
    public T0001 查询服务器时间应答(T8004 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TerminalRegistrationResponse, desc = "终端注册应答")
    public T0001 终端注册应答(T8100 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetTerminalParameters, desc = "设置终端参数")
    public T0001 设置终端参数(T8103 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTerminalParameters, desc = "查询终端参数")
    public T0001 查询终端参数(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TerminalControl, desc = "终端控制")
    public T0001 终端控制(T8105 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTheSpecifiedTerminalParameters, desc = "查询指定终端参数")
    public T0001 查询指定终端参数(T8106 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTerminalProperties, desc = "查询终端属性")
    public T0001 查询终端属性(T0107 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = IssueTheTerminalUpgradePackage, desc = "下发终端升级包")
    public T0001 下发终端升级包(T8108 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = LocationInformationQuery, desc = "位置信息查询")
    public T0200 位置信息查询(JTMessage message) {
        return ClientTest.T0200("1");
    }

    @Mapping(types = TemporaryPositionTrackingControl, desc = "临时位置跟踪控制")
    public T0001 临时位置跟踪控制(T8202 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ManualAcknowledgmentOfAlarmMessages, desc = "人工确认报警消息")
    public T0001 人工确认报警消息(T8203 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ServerInitiatesLinkDetectionRequest, desc = "服务器向终端发起链路检测请求")
    public T0001 服务器向终端发起链路检测请求(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TextMessageDelivery, desc = "文本信息下发")
    public T0001 文本信息下发(T8300 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = EventSettings, desc = "事件设置")
    public T0001 事件设置(T8301 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = IssueAQuestion, desc = "提问下发")
    public T0001 提问下发(T8302 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = InformationOnDemandMenuSettings, desc = "信息点播菜单设置")
    public T0001 信息点播菜单设置(T8303 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = InformationService, desc = "信息服务")
    public T0001 信息服务(T8304 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = CallBack, desc = "电话回拨")
    public T0001 电话回拨(T8400 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetUpPhonebook, desc = "设置电话本")
    public T0001 设置电话本(T8401 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = VehicleControl, desc = "车辆控制")
    public T0001 车辆控制(T8500 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = {DeleteCircularArea, DeleteRectangularArea, DeletePolygonArea, DeleteRoute,}, desc = "删除圆形区域")
    public T0001 删除圆形区域(T8601 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetCircularArea, desc = "设置圆形区域")
    public T0001 设置圆形区域(T8600 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }


    @Mapping(types = SetRectangularArea, desc = "设置矩形区域")
    public T0001 设置矩形区域(T8602 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetPolygonArea, desc = "设置多边形区域")
    public T0001 设置多边形区域(T8604 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetRoute, desc = "设置路线")
    public T0001 设置路线(T8606 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryAreaOrLineData, desc = "查询区域或线路数据")
    public T0001 查询区域或线路数据(T8608 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DriveRecorderDataCollectionCommand, desc = "Drive Recorder Data Collection Command")
    public T0001 行驶记录仪数据采集命令(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DriveRecorderParameterDownloadCommand, desc = "Drive Recorder Parameter Download Command")
    public T0001 行驶记录仪参数下传命令(T8701 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ReportDriverIdentificationInformationRequest, desc = "Report Driver Identification Information Request")
    public T0001 上报驾驶员身份信息请求(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = MultimediaDataUploadResponse, desc = "多媒体数据上传应答")
    public T0001 多媒体数据上传应答(T8800 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = CameraShootsCommandImmediately, desc = "Camera shoots command immediately")
    public T0001 摄像头立即拍摄命令(T8801 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = StoreMultimediaDataRetreival, desc = "Store Multimedia Data Retreival")
    public T0001 存储多媒体数据检索(T8802 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = StoreMultimediaDataUpload, desc = "Store Multimedia Data Upload")
    public T0001 存储多媒体数据上传(T8803 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = RecordingStartCommand, desc = "Recording Start Command")
    public T0001 录音开始命令(T8804 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SingleStoredMultimediaDataRetreivalCommand, desc = "A single stored multimedia data retrieval and upload command")
    public T0001 单条存储多媒体数据检索上传命令(T8805 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DataDownlinkTransparentTransmission, desc = "Data Downlink Transparent Transmission")
    public T0001 数据下行透传(T8900 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = PlatformRSAPublicKey, desc = "Platform RSA Public key")
    public T0001 平台RSA公钥(T0A00_8A00 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    private T0001 buildResult(JTMessage message, int resultCode) {
        T0001 result = new T0001();
        result.copyBy(message);
        result.setMessageId(JT808.TerminalGeneralAnswer);
        result.setClientId(mobileNo);
        result.setSerialNo(serialNo.addAndGet(1));

        result.setResponseSerialNo(message.getSerialNo());
        result.setResponseMessageId(message.getMessageId());
        result.setResultCode(resultCode);
        return result;
    }
}