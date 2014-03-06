/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.customer.upload.web.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.wtd.es.common.db.oracle.DbConnection;
import com.wtd.es.common.web.controller.BaseCRUDController;
import com.wtd.es.common.web.upload.CFileUploadUtils;
import com.wtd.es.customer.upload.entity.PideUpload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 文件上传/下载
 * <p>User: Liang Fan
 * <p>Date: 13-2-11 上午8:46
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "customer/upload")
public class PideUploadController extends BaseCRUDController<PideUpload, Long> {
    
	private DbConnection db = new DbConnection();
	
    public PideUploadController() {
        setResourceIdentity("customer:upload");
    }

    //不再是默认的create，因为下边的create具有多个参数，因此无法覆盖默认的create，因此为了使用该url 我们把父类的url改掉
    @RequestMapping(value = "create/discard", method = RequestMethod.POST)
    @Override
    public String create(Model model, @Valid @ModelAttribute("m") PideUpload upload, BindingResult result, RedirectAttributes redirectAttributes) {
        throw new RuntimeException("discarded method");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(
            Model model,
            HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,
            @Valid @ModelAttribute("m") PideUpload upload, BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (!file.isEmpty()) {
            upload.setSrc(CFileUploadUtils.upload(request, file, result));
            //新增写入sap数据库
            db.update(" insert into sapsr3.zpidedoc values ('500', '"+upload.getName() +"' , '"+upload.getSrc()+"' ,zpideid.nextval)");
        }
        
	    
        return super.create(model, upload, result, redirectAttributes);
    }


    @RequestMapping(value = "{id}/update/discard", method = RequestMethod.POST)
    @Override
    public String update(Model model, @Valid @ModelAttribute("m") PideUpload upload, BindingResult result, @RequestParam(value = "BackURL", required = false) String backURL, RedirectAttributes redirectAttributes) {
        throw new RuntimeException("discarded method");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    public String update(
            Model model,
            HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,
            @Valid @ModelAttribute("m") PideUpload upload, BindingResult result,
            @RequestParam(value = "BackURL") String backURL,
            RedirectAttributes redirectAttributes) {

        if (!file.isEmpty()) {
            upload.setSrc(CFileUploadUtils.upload(request, file, result));
        }
       //更新写入sap数据库
        DbConnection db = new DbConnection();
		Connection con = db.getCon();
		StringBuffer sb = new StringBuffer();
		sb.append("update sapsr3.zpidedoc set name = '"+ upload.getName() + "' ," + " path = '" 
				+upload.getSrc()+ "' where zid = '"+upload.getId()+ "'" );
		ResultSet rs = db.query(sb.toString());
	    db.closeAll();
        return super.update(model, upload, result, backURL, redirectAttributes);
    }


}
