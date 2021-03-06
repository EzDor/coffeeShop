package com.legendary.coffeeShop.dao.repositories;

import com.legendary.coffeeShop.dao.entities.component.Component;
import com.legendary.coffeeShop.dao.entities.component.ComponentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ComponentRepository extends JpaRepository<Component, Long> {
    Component findByType(String componentType);
    List<Component> findAllByTypeInAndStatus(List<String> componentTypeList, ComponentStatus status);
}
