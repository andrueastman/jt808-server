package com.jt808.web.repository;

import com.jt808.web.model.vo.LocationItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LocationRepository extends MongoRepository<LocationItem, String> {

    @Query("{clientId:'?0'}")
    List<LocationItem> findLocationsByClientId(String clientId);

    public long count();
}
