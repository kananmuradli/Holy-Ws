package com.holy.ws.business.concretes;

import com.holy.ws.business.abstracts.UserService;
import com.holy.ws.core.concretes.utilities.result.Result;
import com.holy.ws.core.concretes.utilities.result.success.SuccessResult;
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


    public Result save(User user){
        userCrudRepository.save(user);
        return new SuccessResult("The User saved on Database");
    }

}
