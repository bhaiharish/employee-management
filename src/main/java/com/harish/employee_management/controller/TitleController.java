package com.harish.employee_management.controller;

import com.harish.employee_management.model.Title;
import com.harish.employee_management.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    TitleRepository repository;

    @GetMapping("/get")
    public Title getTitleById(@RequestParam Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping("/add")
    public Title addTitle(@RequestBody Title title) {
        return repository.save(title);
    }

}
