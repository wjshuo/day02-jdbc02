package com.lanou.test3;


import com.lanou.test2.JDBCUtil;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by dllo on 17/11/25.
 * PreparedStatement 类
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //用户输入内容
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = input.next();
//        String name = "asda'or 1=1 --'"; //sql注入
        System.out.println("请输入密码:");
        int psw = input.nextInt();
        String sql = " select * from user where name = ? and password = ?";
        PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,psw);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("欢迎!登陆成功,你访问的内容为: ");
            String info = resultSet.getString("info");
            System.out.println(info);
        }else {
            System.out.println("登录失败");
        }
        JDBCUtil.release(resultSet,preparedStatement,JDBCUtil.getConnection());

    }
//    @Test
//    public void test1() throws SQLException {
//        //用户输入内容
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入用户名:");
//        String name = input.next();
////        String name = "asda'or 1=1 --'"; //sql注入
//        System.out.println("请输入密码:");
//        int psw = input.nextInt();
//
//        Statement statement = JDBCUtil.getConnection().createStatement();
//        String sql = " select * from user where name = '"+name+"' and password = "+psw+"";
//        System.out.println(sql);
//        ResultSet resultSet = statement.executeQuery(sql);
//        if (resultSet.next()){
//            System.out.println("欢迎!登陆成功,你访问的内容为: ");
//            String info = resultSet.getString("info");
//            System.out.println(info);
//        }else {
//            System.out.println("登录失败");
//        }
//        JDBCUtil.release(resultSet,statement,JDBCUtil.getConnection());
//
//    }
//    @Test
//    public void test2() throws SQLException {
//        //用户输入内容
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入用户名:");
//        String name = input.next();
////        String name = "asda'or 1=1 --'"; //sql注入
//        System.out.println("请输入密码:");
//        int psw = input.nextInt();
//        String sql = " select * from user where name = ? and password = ?";
//        PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(sql);
//        preparedStatement.setString(1,name);
//        preparedStatement.setInt(2,psw);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()){
//            System.out.println("欢迎!登陆成功,你访问的内容为: ");
//            String info = resultSet.getString("info");
//            System.out.println(info);
//        }else {
//            System.out.println("登录失败");
//        }
//        JDBCUtil.release(resultSet,preparedStatement,JDBCUtil.getConnection());
//
//    }
}
