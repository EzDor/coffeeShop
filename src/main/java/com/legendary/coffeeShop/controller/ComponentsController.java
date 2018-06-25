package com.legendary.coffeeShop.controller;

import com.legendary.coffeeShop.dao.entities.Component;
import com.legendary.coffeeShop.service.ComponentService;
import com.legendary.coffeeShop.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @Autowired
    private ValidationService validationService;

    @GetMapping("/saladIngredients")
    @ResponseBody
    public Set<Component> getSaladIngredients() {

        return componentService.getSaladIngredients();
    }
}
