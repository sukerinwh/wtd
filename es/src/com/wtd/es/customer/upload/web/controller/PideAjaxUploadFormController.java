/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.customer.upload.web.controller;

import com.wtd.es.common.Constants;


import com.wtd.es.customer.upload.entity.PideUpload;
import com.wtd.es.customer.upload.service.PideUploadService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * 文件上传/下载
 * <p>User: Liang Fan
 * <p>Date: 13-2-11 上午8:46
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "customer/upload/ajax")
public class PideAjaxUploadFormController {

    @Autowired
    private PideUploadService uploadService;

    @RequiresPermissions("customer:upload:create")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute(Constants.OP_NAME, "新增");
        if (!model.containsAttribute("upload")) {
            model.addAttribute("upload", new PideUpload());
        }
        return "customer/upload/ajax/editForm";
    }

    @RequiresPermissions("customer:upload:create")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid PideUpload upload, RedirectAttributes redirectAttributes) {

        uploadService.save(upload);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "创建文件成功");
        return "redirect:/customer/upload";
    }

}
