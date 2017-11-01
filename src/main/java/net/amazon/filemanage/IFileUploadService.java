/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.amazon.filemanage;

import net.amazon.filemanage.dto.Response;

/**
 *
 * @author medineshkatwal
 */
public interface IFileUploadService {

    public Response uploadFile(String uploadFile, String fileName);

}
