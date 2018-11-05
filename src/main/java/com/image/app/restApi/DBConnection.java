package com.image.app.restApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
   
    public Connection connectDataBase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost/medical_image?";
            String user = "imageUser";
            String pw = "passImgUsr";            
            connect = DriverManager
                    .getConnection(URL, user, pw);
            return connect;
        } catch (Exception e) {
            throw e;
        }
    }
}