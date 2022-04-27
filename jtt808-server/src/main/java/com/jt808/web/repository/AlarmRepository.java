package com.jt808.web.repository;

import com.jt808.web.model.vo.AlarmItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlarmRepository extends MongoRepository<AlarmItem, String> {
    @Query("{locationId:'?0'}")
    AlarmItem findItemByLocationId(String locationId);

    @Query("{alarmId:'?0'}")
    AlarmItem findItemByAlarmId(String alarmId);

    @Query("{deviceId:'?0'}")
    List<AlarmItem> findItemByDeviceId(String deviceId);

    public long count();
}
