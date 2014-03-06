/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.common.entity.search.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * <p>User: Liang Fan
 * <p>Date: 13-1-17 上午11:43
 * <p>Version: 1.0
 */
public class SearchException extends NestedRuntimeException {

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
