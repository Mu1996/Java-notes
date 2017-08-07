package com.muyonghui.dao.util;/*
 * Created by muyonghui on 2017/8/2.
 */

import java.sql.*;

//import org.gjt.mm.mysql.Driver
public class BaseConnection {

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/muyhsql","root","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeRes(Connection connection, PreparedStatement preparedStatement){

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closeRes(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
