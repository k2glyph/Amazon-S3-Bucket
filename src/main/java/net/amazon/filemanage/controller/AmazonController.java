/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.amazon.filemanage.controller;

import net.amazon.filemanage.IFileUploadService;
import net.amazon.filemanage.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author medineshkatwal
 */
@RestController
public class AmazonController {

    @Autowired
    private IFileUploadService service;

    @RequestMapping(value = "/")
    public String home() {
        return "Amazon Controller";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Response uploadfile(
            @RequestParam(value = "file", required = true) String uploadFile,
            @RequestParam(value = "filename", required = true) String filename) {
        return service.uploadFile(uploadFile, filename);
    }
}
