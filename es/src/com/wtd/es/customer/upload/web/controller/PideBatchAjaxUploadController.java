/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.customer.upload.web.controller;

import com.wtd.es.common.Constants;
import com.wtd.es.common.web.upload.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ajax批量文件上传/下载
 * <p>User: Liang Fan
 * <p>Date: 13-2-11 上午8:46
 * <p>Version: 1.0
 */
@Controller
public class PideBatchAjaxUploadController {


    //最大上传大小 字节为单位
    private long maxSize = FileUploadUtils.DEFAULT_MAX_SIZE;
    //允许的文件内容类型
    private String[] allowedExtension = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;
    //文件上传下载的父目录
    private String baseDir = FileUploadUtils.getDefaultBaseDir();


    @RequiresPermissions("customer:upload:create")
    @RequestMapping(value = "ajaxPideUpload", method = RequestMethod.GET)
    public String showAjaxUploadForm(Model model) {
        model.addAttribute(Constants.OP_NAME, "新增");
        return "customer/upload/ajax/uploadForm";
    }

}
