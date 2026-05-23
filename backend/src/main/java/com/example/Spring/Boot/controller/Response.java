package com.example.Spring.Boot.controller;

public class Response {
    private boolean success;
    private String message;
    private String status;

    public Response(){

    }
    public Response(boolean success, String message, String status){
        this.success=success;
        this.message=message;
        this.status=status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
