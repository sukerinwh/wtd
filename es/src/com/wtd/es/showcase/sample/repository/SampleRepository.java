/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.showcase.sample.repository;

import com.wtd.es.common.repository.BaseRepository;
import com.wtd.es.showcase.sample.entity.Sample;

/**
 * <p>User: Liang Fan
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface SampleRepository extends BaseRepository<Sample, Long> {

    Sample findByName(String name);

}
