package com.lanou;

import org.junit.Test;

import java.sql.*;

/**
 * Created by dllo on 17/11/24.
 */
public class SecondJDBC {
    //@Test//注解
    //public void test1() throws SQLException {
       //左边三角运行要求  权限只能是public .返回值为void
//        String name="wade' or 1=1 --'";
//        String name="wwu";
//        String password="11133";
//        Connection connection=JDBCUtil.getConnection();
//        Statement statement=connection.createStatement();
//
//        String sql="select*from user where "+"name ='"+name+"' and password='"+password+"'  ";
//        System.out.println(sql);
//        ResultSet resultSet=statement.executeQuery(sql);
//        if (resultSet.next()){
//            System.out.println("登录成功  你访问的信息是");
//            String info=resultSet.getString("info");
//            System.out.println(info);
//        }else{
//            System.out.println("对不起 你的用户名或密码不对 请重新登录");
//
//        }

    /*
    Statement执行数据库语句不会做出预处理,什么样的语句都执行
    当遇见sql注入问题的时候就会出现安全性的问题
    使用PreparedStatement语句,因为PreparedStatement可以对sql语句进行预处理
    判断sql语句的合法性
    如果合法就再回去找添加参数 ,再次执行正确的sql语句
     */
        @Test
        public void test1() throws SQLException {
        //String name="wade' or 1=1 --'";
        String name="wwu";
        String password="11133";
        Connection connection=JDBCUtil.getConnection();
        String sql="select * from user where name = ? and password= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            //
            //setString()
            //参数1?的索引位置
            //参数2 ?中添加的信息

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);

            ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("登录成功  你访问的信息是");
            String info=resultSet.getString("info");
            System.out.println(info);
        }else{
            System.out.println("对不起 你的用户名或密码不对 请重新登录");

        }


    }





}
