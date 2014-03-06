/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.showcase.deleted.service;

import com.wtd.es.common.service.BaseService;
import com.wtd.es.showcase.deleted.entity.DeletedSample;
import com.wtd.es.showcase.deleted.repository.DeletedSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: Liang Fan
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class DeletedSampleService extends BaseService<DeletedSample, Long> {

    private DeletedSampleRepository getSampleRepository() {
        return (DeletedSampleRepository) baseRepository;
    }

    public DeletedSample findByName(String name) {
        return getSampleRepository().findByName(name);
    }

}
