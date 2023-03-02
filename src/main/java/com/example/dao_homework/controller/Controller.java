package com.example.dao_homework.controller;

import com.example.dao_homework.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "products/fetch-product")
    public List<String> fetchName(@RequestParam String name){
        return repository.getProductName(name);
    }
}
