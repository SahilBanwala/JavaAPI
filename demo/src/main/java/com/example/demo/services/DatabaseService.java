package com.example.demo.services;

import com.example.demo.configuration.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    ConfigService configService;

    @Autowired
    Queries query;
    public  Connection getConnectionStatement() throws SQLException {
        Connection con= DriverManager.getConnection(
                configService.DbUrl,configService.ServerName,configService.ServerPass);
        return con;
    }
    public List<Hello> get() throws SQLException {
       Connection conn=getConnectionStatement();
       Statement stmt= conn.createStatement();
        return query.get(stmt);
    }

}
