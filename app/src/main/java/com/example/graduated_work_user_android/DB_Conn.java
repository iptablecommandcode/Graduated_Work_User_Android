package com.example.graduated_work_user_android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Conn {
    public void DBConn() {
        try {
            String str = "org.h2.Driver";
            Class.forName(str);
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");
            System.out.println("연결 성공");
            conn.close();
            System.out.println("연결 종료");
            } catch (SQLException | ClassNotFoundException e) {
            System.out.println("SQLException: " + e.getMessage());
//            System.out.println("SQLState: " + e.getSQLState());
        }
    }
}
