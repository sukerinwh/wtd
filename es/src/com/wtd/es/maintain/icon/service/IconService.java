/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.maintain.icon.service;

import com.wtd.es.common.service.BaseService;
import com.wtd.es.maintain.icon.entity.Icon;
import com.wtd.es.maintain.icon.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: Liang Fan
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class IconService extends BaseService<Icon, Long> {

    private IconRepository getIconRepository() {
        return (IconRepository) baseRepository;
    }

    public Icon findByIdentity(String identity) {
        return getIconRepository().findByIdentity(identity);
    }
}
