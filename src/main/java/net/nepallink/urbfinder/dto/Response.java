/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nepallink.urbfinder.dto;

/**
 *
 * @author medineshkatwal
 */
public class Response {

    private String result;
    private String message;

    public Response(String result, String message) {
        this.result = result;
        this.message = message;
    }
    
    public String getResult() {
        return this.result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setResult(String result) {
        this.result = result;

    }

    public void setMessage(String message) {
        this.message = message;
    }
}
