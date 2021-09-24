package com.holy.ws.apı.controller;

import com.holy.ws.business.abstracts.UserService;
import com.holy.ws.core.concretes.utilities.result.Result;
import com.holy.ws.core.concretes.utilities.result.error.ErrorDataResult;
import com.holy.ws.entities.concretes.user.User;
import io.swagger.models.Response;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/1.0/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Result> createUser(@RequestBody User user){
        return ResponseEntity.ok(this.userService.save(user));
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(validationErrors,"These are Errors ");
    }
}
