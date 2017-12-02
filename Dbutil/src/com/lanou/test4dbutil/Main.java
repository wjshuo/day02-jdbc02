package com.lanou.test4dbutil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/11/26.
 */
public class Main {//        //查询数据
//        String select = (String) queryRunner.query(sql3,new ScalarHandler(4));
//        System.out.println("查询结果为:"+select);
//        //System.out.println("修改了:"+select+"条 数据");
//
//
//    }

    /**
     * 需求：向user表中插入数据
     * update
     */
    @Test
    public void test1() throws SQLException {
        //第一步:创建queryRunner对象，用来操作sql语句
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        //第二步:创建sql语句
        String sql = "insert into user values(null,?,?,?)";
        //第三步:执行sql语句
        //注意:给SQL语句设置参数的时候要按照user表中的字段的顺序
        int update = queryRunner.update(sql, "CAND", 456456, "ISCAND");
        System.out.println("修改了:" + update + "条数据");
    }

    /**
     * 需求:删除user表中的CAND这条数据
     * update
     */
    @Test
    public void test2() throws SQLException {
        //第一步:创建queryRunner对象,用来操作sql语言
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        //第二步:创建sql语句
        String sql = "delete from user where name = ? and password = ?";
        //第三步:执行sql语句
        int update = queryRunner.update(sql, "CAND", 456456);
        System.out.println("修改了:" + update + "条数据");
    }

    /**
     * 需求:修改user表中WARD的info
     * update
     */
    @Test
    public void test3() throws SQLException {
        //第一步:创建queryRunner对象,用来操作SQL语言
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        //第二步:创建SQL语句
        String sql = "update user set info = ? where name = ?";
        //第三步:执行SQL语句
        int update = queryRunner.update(sql, "我是WARD", "WARD");
        System.out.println("修改了:" + update + "条数据");
    }

    /**
     * -->1.ScalarHandler:将查询结果集第一行的某一列放到某个对象中;精确定位到某个值
     * 需求:查询user表中的数据name
     * 利用ResultSetHandler的实现类:ScalarHandler
     */
    @Test
    public void query1() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from user";
        String name = (String) queryRunner.query(sql, new ScalarHandler(2));
        System.out.println("查询结果为:" + name);
    }

    /**
     * -->2.MapListHandler:将查询结果的每一行存入到一个map中,键为列名,值为各值
     * 然后再将map存入list中
     * 需求:查询user表中的数据
     * 利用ResultSetHandler的实现类:MapListHandler
     */
    @Test
    public void query2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from user";
        List<Map<String, Object>> maps = queryRunner.query(sql, new MapListHandler());
        System.out.println(maps);
    }

    /**
     * -->3.MapHandler:将查询结果的第一行存入到一个map中,键名为列名,值为各列值
     * 需求: 查询user表中的数据
     * 利用ResultSetHandler的实现类:MapHandler
     */
    @Test
    public void query3() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from user";
        Map<String, Object> map = queryRunner.query(sql, new MapHandler());
        System.out.println(map);

    }
    /**
     * -->4.BeanHandler:将查询的结果的每一行封装到一个javabean对象中，
     * 然后再将这些对象存入list中；
     * 需求: 查询user表中的数据
     * 利用ResultSetHandler的实现类:BeanListHandler
     */
    @Test
    public void query4() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from user";
        List<Person> list = queryRunner.query(sql,new BeanListHandler<Person>(Person.class));
        System.out.println(list);
    }
}
