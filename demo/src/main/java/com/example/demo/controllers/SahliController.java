package com.example.demo.controllers;

import com.example.demo.configuration.ConfigService;
import com.example.demo.models.Student;
import com.example.demo.services.DatabaseService;
import com.example.demo.services.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Sahli")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class SahliController {

    @Autowired
    ConfigService configService;
    @Autowired
    DatabaseService databaseService;

    @PutMapping
    public void update(@RequestBody Student student) throws SQLException {
        databaseService.update(student.RollNo,student.Name);
    }

    @PostMapping
    public void Insert(@RequestBody Student student) throws SQLException {
        databaseService.insert(student.RollNo,student.Name);
    }
    @DeleteMapping
    public void delete(@RequestBody Student student) throws SQLException {
        databaseService.delete(student.RollNo);
    }

    @GetMapping("/{id}")
    public Hello getStudentByRollNo(@PathVariable("id") int id) throws SQLException {
        return databaseService.getById(id);
    }

    @GetMapping
    public List<Hello> getAllStudents() throws SQLException {
//        List<String> aaa = new ArrayList<>();
//        aaa.add("Ramkesh");
//        aaa.add("Ramkesh1");
//        aaa.add("Ramkesh2");
        return databaseService.get();

//        return aaa;
    }
}
