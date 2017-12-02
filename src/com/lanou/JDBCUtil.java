package com.lanou;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by dllo on 17/11/24.
 */
public class JDBCUtil {
    private static String driverClass,database,user,password;
    //静态代码块,优先执行.
    static {
        //初始化ClassLoader
        ClassLoader classLoader=JDBCUtil.class.getClassLoader();
        //加载文件,转化为流
        InputStream inputStream=classLoader.getResourceAsStream("jdbc.properties");
        //初始化配置对象
        Properties properties=new Properties();
        try {
            //加载流里面的信息
            properties.load(inputStream);
            driverClass=properties.getProperty("driverClass");
            database=properties.getProperty("database");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            Class.forName(driverClass);//优先驱动数据库.

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    //建立连接 静态方法 直接用类型就可以调用静态方法
    public static Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection(database,user,password);
        return connection;
    }//此时括号红是因为无返回值
    //释放资源
    //此时没有具体的connection,statement,resultset,利用形参
    public static void   release(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
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
