package com.lanou.test2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/24.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Statement statement = JDBCUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
        List<EMPBean> data = new ArrayList<>();
        while (resultSet.next()) {
            EMPBean empBean = new EMPBean();
            empBean.setEname(resultSet.getString("ename"));
            empBean.setJob(resultSet.getString("job"));
            empBean.setEmpno(resultSet.getInt("empno"));
            empBean.setSal(resultSet.getInt("sal"));
            empBean.setHiredate(resultSet.getDate("hiredate"));
            data.add(empBean);
        }
        JDBCUtil.release(resultSet, statement, JDBCUtil.getConnection());

        for (EMPBean bean : data) {
            System.out.println(bean.getEname() + " "
                    + bean.getJob() + " "
                    + bean.getEmpno() + " "
                    + bean.getSal() + " "
                    + bean.getHiredate());
        }
    }
}
