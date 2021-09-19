package com.holy.ws.core.concretes.utilities.result.success;

import com.holy.ws.core.concretes.utilities.result.Result;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true,message);
    }
}
