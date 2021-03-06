package com.holy.ws.core.concretes.utilities.result;



public class Result implements IResult{
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this(success); // Bool Constractoru cagiri
        this.message = message;
    }

    public Result(boolean success) { //bool Constroctor
        this.success = success;
    }

    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }
}
