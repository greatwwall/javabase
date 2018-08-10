package com.xujun.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月23日 下午4:57:47 
  */

public class JdbcTest {

    private static final String URL = "jdbc:mysql://localhost:3306/springboot";

    private static final String USER = "springboot";

    private static final String PASSWORD = "springboot";

    public static void select(Connection conn) throws SQLException {
        System.out.println("------------select--------------------");
        String sql = "select id, name, age from user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getInt("age"));
        }
    }

    public static void create(Connection conn) throws SQLException {
        System.out.println("------------create--------------------");
        String sql = "insert into user (name, age) values (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "lisi");
        ps.setInt(2, 33);
        ps.execute();
        select(conn);
    }

    public static void delete(Connection conn) throws SQLException {
        System.out.println("------------delete--------------------");
        String sql = "delete from user where name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "zhangsan");
        ps.execute();
        select(conn);
    }

    public static void update(Connection conn) throws SQLException {
        System.out.println("------------update--------------------");
        String sql = "update user set age=? where name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 25);
        ps.setString(2, "wangwu");
        ps.execute();
        select(conn);
    }

    public static void batchInsert(Connection conn) throws SQLException {
        System.out.println("------------batchInsert--------------------");
        conn.setAutoCommit(false);
        String sql = "insert into user (name, age) values (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 1; i < 10000; i++) {
            ps.setString(1, "admin" + i);
            ps.setInt(2, i);
            ps.addBatch();
            if (i % 1000 == 0) {
                ps.executeBatch();
            }
        }
        ps.executeBatch();
        conn.commit();
    }

    public static void count(Connection conn) throws SQLException {
        System.out.println("------------count--------------------");
        String sql = "select count(1) from user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("user count is : " + rs.getInt(1));
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        select(conn);
        create(conn);
        delete(conn);
        update(conn);
        batchInsert(conn);
        count(conn);
        conn.close();
    }
}
