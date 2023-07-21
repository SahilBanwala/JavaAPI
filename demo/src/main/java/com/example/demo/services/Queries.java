package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class Queries {

public List<Hello> get(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery("select * from hello");
    List<Hello> lsHello = new ArrayList<>();
    while(rs.next()) {
        Hello hello = new Hello();
        hello.id = rs.getInt(1);
        hello.name = rs.getString(2);
        lsHello.add(hello);
        System.out.println(rs.getInt(1) + "  " + rs.getString(2) );
    }
    rs.close();
    return lsHello;
}

}

