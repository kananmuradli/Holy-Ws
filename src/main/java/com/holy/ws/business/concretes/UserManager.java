package com.holy.ws.business.concretes;

import com.holy.ws.business.abstracts.UserService;
import com.holy.ws.dataAccess.abstracts.user.UserCrudRepository;
import com.holy.ws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {


    private final UserCrudRepository userCrudRepository;

    @Autowired
    public UserManager(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }


    User save(User user){
        userCrudRepository.save(user);
        return user;
    }

}
