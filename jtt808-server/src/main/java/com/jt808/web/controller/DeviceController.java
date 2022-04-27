package com.jt808.web.controller;

import com.jt808.commons.model.APIResult;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.T0104;
import com.jt808.protocol.t808.T8106;
import com.jt808.web.model.vo.AlarmItem;
import com.jt808.web.model.vo.DeviceInfo;
import com.jt808.web.model.vo.LocationItem;
import com.jt808.web.repository.AlarmRepository;
import com.jt808.web.repository.DeviceRepository;
import com.jt808.web.repository.LocationRepository;
import io.github.yezhihao.netmc.session.Session;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collection;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AlarmRepository alarmRepository;

    @Operation(summary = "Get list of registered devices")
    @GetMapping("list")
    public APIResult<Collection<DeviceInfo>> all() {
        Collection<DeviceInfo> all = deviceRepository.findAll();
        return new APIResult<>(all);
    }

    @Operation(summary = "Get list of devices location data")
    @GetMapping("locations")
    public APIResult<Collection<LocationItem>> getLocations(@Parameter(description = "Terminal Id number") @RequestParam String clientId){
        Collection<LocationItem> all = locationRepository.findLocationsByClientId(clientId);
        return new APIResult<>(all);
    }

    @Operation(summary = "Get list of devices alarm data")
    @GetMapping("alarms")
    public APIResult<Collection<AlarmItem>> getAlarms(@Parameter(description = "Terminal Id number") @RequestParam String clientId){
        Collection<AlarmItem> all = alarmRepository.findItemByDeviceId(clientId);
        return new APIResult<>(all);
    }

}
