package com.lanou.test2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by dllo on 17/11/24.
 */
public class JDBCUtil {
    private static String driverClass,user,database,password,characterEncoding;
    static {

        try {
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            characterEncoding = properties.getProperty("characterEncoding");


            Class.forName(driverClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(database,user,password);


        return connection;
    }
    public static void release(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (connection!=null){
            connection.close();
        }

    }

}
