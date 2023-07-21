package com.example.demo.controllers;

import com.example.demo.configuration.ConfigService;
import com.example.demo.services.DatabaseService;
import com.example.demo.services.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Sahli")
public class SahliController {

    @Autowired
    ConfigService configService;
    @Autowired
    DatabaseService databaseService;
    @GetMapping("/chota")
    public List<Hello> getAllStudents() throws SQLException {
//        List<String> aaa = new ArrayList<>();
//        aaa.add("Ramkesh");
//        aaa.add("Ramkesh1");
//        aaa.add("Ramkesh2");
        return databaseService.get();

//        return aaa;
    }
}
