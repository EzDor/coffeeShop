package com.legendary.coffeeShop.controller;

import com.legendary.coffeeShop.controller.form.UserForm;
import com.legendary.coffeeShop.service.UserService;
import com.legendary.coffeeShop.service.ValidationService;
import com.legendary.coffeeShop.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidationService validationService;


    @PostMapping("/signUp")
    @ResponseBody
    public Status addNewUser(@RequestBody UserForm userForm) {
        validationService.validateUserForm(userForm);
        return userService.createUser(userForm);
    }

}
