package com.jt808.web.model.vo;

import io.github.yezhihao.netmc.util.AdapterMap;
import io.swagger.v3.oas.annotations.media.Schema;
import com.jt808.protocol.commons.transform.parameter.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

public class Parameters {

    @Schema(description = "Numeric parameter list (BYTE, WORD)")
    private Map<Integer, Integer> parametersInt;
    @Schema(description = "Numeric parameter list (DWORD, QWORD)")
    private Map<Integer, String> parametersLong;
    @Schema(description = "character parameter list")
    private Map<Integer, String> parametersStr;
    @Schema(description = "Image Analysis Alarm Parameter Setting(1078)")
    private ParamImageIdentifyAlarm paramImageIdentifyAlarm;
    @Schema(description = "Special alarm recording parameter setting(1078)")
    private ParamVideoSpecialAlarm paramVideoSpecialAlarm;
    @Schema(description = "Audio and video channel list settings (1078)")
    private ParamChannels paramChannels;
    @Schema(description = "Terminal sleep wake-up mode setting data format(1078)")
    private ParamSleepWake paramSleepWake;
    @Schema(description = "Audio and video parameter settings (1078)")
    private ParamVideo paramVideo;
    @Schema(description = "Individual video channel parameter settings (1078)")
    private ParamVideoSingle paramVideoSingle;
    @Schema(description = "Blind spot monitoring system parameters (Su Biao)")
    private ParamBSD paramBSD;
    @Schema(description = "胎压监测系统参数(苏标)")
    private ParamTPMS paramTPMS;
    @Schema(description = "Driver Condition Monitoring System Parameters (Su Biao)")
    private ParamDSM paramDSM;
    @Schema(description = "Advanced Driver Assistance System Parameters (Su Biao)")
    private ParamADAS paramADAS;

    public Map<Integer, Integer> getParametersInt() {
        return parametersInt;
    }

    public void setParametersInt(Map<Integer, Integer> parametersInt) {
        this.parametersInt = parametersInt;
    }

    public Map<Integer, String> getParametersLong() {
        return parametersLong;
    }

    public void setParametersLong(Map<Integer, String> parametersLong) {
        this.parametersLong = parametersLong;
    }

    public Map<Integer, String> getParametersStr() {
        return parametersStr;
    }

    public void setParametersStr(Map<Integer, String> parametersStr) {
        this.parametersStr = parametersStr;
    }

    public ParamADAS getParamADAS() {
        return paramADAS;
    }

    public void setParamADAS(ParamADAS paramADAS) {
        this.paramADAS = paramADAS;
    }

    public ParamBSD getParamBSD() {
        return paramBSD;
    }

    public void setParamBSD(ParamBSD paramBSD) {
        this.paramBSD = paramBSD;
    }

    public ParamChannels getParamChannels() {
        return paramChannels;
    }

    public void setParamChannels(ParamChannels paramChannels) {
        this.paramChannels = paramChannels;
    }

    public ParamDSM getParamDSM() {
        return paramDSM;
    }

    public void setParamDSM(ParamDSM paramDSM) {
        this.paramDSM = paramDSM;
    }

    public ParamImageIdentifyAlarm getParamImageIdentifyAlarm() {
        return paramImageIdentifyAlarm;
    }

    public void setParamImageIdentifyAlarm(ParamImageIdentifyAlarm paramImageIdentifyAlarm) {
        this.paramImageIdentifyAlarm = paramImageIdentifyAlarm;
    }

    public ParamSleepWake getParamSleepWake() {
        return paramSleepWake;
    }

    public void setParamSleepWake(ParamSleepWake paramSleepWake) {
        this.paramSleepWake = paramSleepWake;
    }

    public ParamTPMS getParamTPMS() {
        return paramTPMS;
    }

    public void setParamTPMS(ParamTPMS paramTPMS) {
        this.paramTPMS = paramTPMS;
    }

    public ParamVideo getParamVideo() {
        return paramVideo;
    }

    public void setParamVideo(ParamVideo paramVideo) {
        this.paramVideo = paramVideo;
    }

    public ParamVideoSingle getParamVideoSingle() {
        return paramVideoSingle;
    }

    public void setParamVideoSingle(ParamVideoSingle paramVideoSingle) {
        this.paramVideoSingle = paramVideoSingle;
    }

    public ParamVideoSpecialAlarm getParamVideoSpecialAlarm() {
        return paramVideoSpecialAlarm;
    }

    public void setParamVideoSpecialAlarm(ParamVideoSpecialAlarm paramVideoSpecialAlarm) {
        this.paramVideoSpecialAlarm = paramVideoSpecialAlarm;
    }

    public Map<Integer, Object> toMap() {
        Map<Integer, Object> map = new TreeMap<>();

        if (parametersInt != null && !parametersInt.isEmpty())
            map.putAll(parametersInt);

        if (parametersLong != null && !parametersLong.isEmpty())
            map.putAll(new AdapterMap(parametersLong, (Function<String, Long>) Long::parseLong));

        if (parametersStr != null && !parametersStr.isEmpty())
            map.putAll(parametersStr);

        if (paramADAS != null)
            map.put(paramADAS.key, paramADAS);
        if (paramBSD != null)
            map.put(paramBSD.key, paramBSD);
        if (paramChannels != null)
            map.put(paramChannels.key, paramChannels);
        if (paramDSM != null)
            map.put(paramDSM.key, paramDSM);
        if (paramImageIdentifyAlarm != null)
            map.put(paramImageIdentifyAlarm.key, paramImageIdentifyAlarm);
        if (paramSleepWake != null)
            map.put(paramSleepWake.key, paramSleepWake);
        if (paramTPMS != null)
            map.put(paramTPMS.key, paramTPMS);
        if (paramVideo != null)
            map.put(paramVideo.key, paramVideo);
        if (paramVideoSingle != null)
            map.put(paramVideoSingle.key, paramVideoSingle);
        if (paramVideoSpecialAlarm != null)
            map.put(paramVideoSpecialAlarm.key, paramVideoSpecialAlarm);
        return map;
    }
}