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
//        System.out.println(rs.getInt(1) + "  " + rs.getString(2) );
    }
    rs.close();
    return lsHello;
}
public Hello getById(Statement stmt,int id) throws SQLException {
    ResultSet rs=stmt.executeQuery("Select * from hello where id='"+id+"'");
    Hello h=new Hello();
    if(rs.next()) {
        h.id = rs.getInt(1);
        h.name = rs.getString(2);
    }
    rs.close();
    return h;
}

public void insert(Statement stmt,int RollNo,String Name) throws SQLException {
    ResultSet rs=stmt.executeQuery("SELECT count(id) As TotalUser FROM hello WHERE id = '"+RollNo+"' ");
    var ans = 0;
    if(rs.next()) {
       ans = rs.getInt("TotalUser");
    }
    if(ans<=0){
        stmt.executeUpdate("Insert into hello values('" + RollNo + "','" + Name + "')");
    }
    else {
        throw new SQLException("your data already in database use update button");
    }
}
    public void delete(Statement stmt,int RollNo) throws SQLException {

        stmt.executeUpdate("delete from hello where id='"+RollNo+"'");
    }
    public void update(Statement stmt,int RollNo,String Name) throws SQLException {

        if(stmt.executeQuery("Select EXISTS(SELECT * FROM hello WHERE id = '"+RollNo+"')")!=null){
            stmt.executeUpdate("update hello set Name ='" + Name + "'  where id='" + RollNo + "'");
        }

    }

}

