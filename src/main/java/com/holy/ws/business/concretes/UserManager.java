package com.holy.ws.business.concretes;

import com.holy.ws.dataAccess.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {


    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
