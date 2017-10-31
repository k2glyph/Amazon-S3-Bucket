/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nepallink.urbfinder.service;

import net.nepallink.urbfinder.IFileUploadService;
import net.nepallink.urbfinder.application.Application;
import net.nepallink.urbfinder.configuration.ApplicationConfig;
import net.nepallink.urbfinder.dto.Response;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author medineshkatwal
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class AmazonServiceTest {

    @Autowired
    private IFileUploadService service;
    private Logger logger;

    public AmazonServiceTest() {
        this.logger = LoggerFactory.getLogger(AmazonServiceTest.class);
    }

    @Test
    public void testUploadFile() {
        String uploadFile = "/home/medineshkatwal/Documents/main.c";
        String fileName = "main.c";
        logger.info("Request UploadFile: {} FileName: {}", uploadFile, fileName);
        Response response = service.uploadFile(uploadFile, fileName);
        Assert.assertEquals("success", response.getResult());
    }
}
