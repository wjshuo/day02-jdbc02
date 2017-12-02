package com.lanou;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by dllo on 17/11/24.
 */
public class JDBCMain {
    //使用工具类
    public static void main(String[] args) throws SQLException {
        //创建connection对象,建立连接


        ResultSet resultSet=JDBCUtil.getConnection().createStatement().executeQuery("SELECT * FROM lanou.EMP");
        while (resultSet.next()){
            System.out.println(resultSet.getString("ename"));
        }
        //释放资源
        JDBCUtil.release(resultSet,JDBCUtil.getConnection().createStatement(),JDBCUtil.getConnection());







    }
}
