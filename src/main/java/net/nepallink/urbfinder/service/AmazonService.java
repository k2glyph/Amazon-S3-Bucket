/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nepallink.urbfinder.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import net.nepallink.urbfinder.IFileUploadService;
import net.nepallink.urbfinder.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author medineshkatwal
 */
@Service
public class AmazonService implements IFileUploadService {

    @Autowired
    private AmazonS3 s3client;

    @Value("${aws_namecard_bucket}")
    private String nameCardBucket;
    private Logger logger = LoggerFactory.getLogger(AmazonService.class);

    /*
    * upload file to folder and set it to public
     */
    @Override
    public Response uploadFile(String uploadFile, String filename) {
        logger.info("Request UploadFile: {} FileName: {}", uploadFile, filename);
        String fileNameInS3 = filename;
        logger.info("S3clientObject: {}", s3client);
        s3client.putObject(
                new PutObjectRequest(nameCardBucket,
                        fileNameInS3, new File(uploadFile))
                        .withCannedAcl(CannedAccessControlList.PublicRead));
        return new Response("success", "File Uploaded to s3 bucket: " + nameCardBucket);
    }

}
