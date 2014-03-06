/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.customer.upload.repository;

import com.wtd.es.common.repository.BaseRepository;
import com.wtd.es.customer.upload.entity.PideUpload;



/**
 * <p>User: Liang Fan
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface PideUploadRepository extends BaseRepository<PideUpload, Long> {

    PideUpload findByName(String name);

}
