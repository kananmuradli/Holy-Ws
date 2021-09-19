package com.holy.ws.core.concretes.utilities.result.error;

import com.holy.ws.core.concretes.utilities.result.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
