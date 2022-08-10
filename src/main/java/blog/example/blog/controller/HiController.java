package blog.example.blog.controller;

import org.springframework.stereotype.Controller;

import java.sql.*;

@Controller
public class HiController {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306",
                    "yuju",
                    "1234"
            );

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "show databases"
            );

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
