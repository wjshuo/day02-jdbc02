package com.lanou.test1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/24.
 */
public class EMPMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/lanou?user=root" +
                        "&password=123456" +
                        "&characterEncoding=utf8");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
        List<EMPBean> data = new ArrayList<>();
        while (resultSet.next()){
            EMPBean empBean = new EMPBean();
            empBean.setEname(resultSet.getString("ename"));
            empBean.setJob(resultSet.getString("job"));
            empBean.setSal(resultSet.getInt("sal"));
            empBean.setHiredate(resultSet.getDate("hiredate"));
            data.add(empBean);
        }
        resultSet.close();
        statement.close();
        connection.close();
        for (EMPBean bean : data) {
            System.out.println(bean.getEname() + "  "
                    + bean.getJob() + "  "
                    + bean.getSal() + "  "
                    + bean.getHiredate());
        }
    }
}
