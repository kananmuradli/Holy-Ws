package com.holy.ws.business.abstracts;


import com.holy.ws.core.concretes.utilities.result.Result;
import com.holy.ws.entities.concretes.user.User;
import org.springframework.stereotype.Service;


public interface UserService {

    Result save(User user);
    
}
