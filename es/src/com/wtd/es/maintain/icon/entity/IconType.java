/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.maintain.icon.entity;

/**
 * 图标类型
 * <p>User: Liang Fan
 * <p>Date: 13-4-24 下午3:25
 * <p>Version: 1.0
 */
public enum IconType {
    css_class("css类图标"), upload_file("文件图标"), css_sprite("css精灵图标");

    private final String info;

    private IconType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
