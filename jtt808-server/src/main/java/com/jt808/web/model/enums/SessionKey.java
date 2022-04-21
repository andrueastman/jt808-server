package com.jt808.web.model.enums;

import io.github.yezhihao.netmc.session.Session;
import com.jt808.protocol.t808.T0200;

public enum SessionKey {

    DeviceInfo,
    Snapshot;

    public static com.jt808.web.model.vo.DeviceInfo getDeviceInfo(Session session) {
        return (com.jt808.web.model.vo.DeviceInfo) session.getAttribute(DeviceInfo);
    }

    public static T0200 getSnapshot(Session session) {
        return (T0200) session.getAttribute(Snapshot);
    }

}