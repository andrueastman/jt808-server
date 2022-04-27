package com.jt808.web.repository;

import com.jt808.web.model.vo.DeviceInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DeviceRepository extends MongoRepository<DeviceInfo, String> {

    @Query("{clientId:'?0'}")
    DeviceInfo findItemByClientId(String clientId);


    public long count();
}
