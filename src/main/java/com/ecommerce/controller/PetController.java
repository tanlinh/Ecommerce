package com.ecommerce.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    @GetMapping("")
    public String listPets() {
        return "[]";
    }
}