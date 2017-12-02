package com.lanou.test4dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by dllo on 17/11/25.
 */
public class jdbcUtils {
    // 配置文件的默认配置！要求你必须给出c3p0-config.xml！！！
    /**
     * 获得C3P0连接池对象
     */
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 使用连接池返回一个连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return (Connection) dataSource.getConnection();
    }

    /**
     * 返回连接池对象！
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

}
