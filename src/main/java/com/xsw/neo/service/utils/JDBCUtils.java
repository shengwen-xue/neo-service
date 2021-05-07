package com.xsw.neo.service.utils;

import com.xsw.neo.service.model.entity.Person;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author xueshengwen
 * @since 2021/4/7 11:31
 */
public class JDBCUtils {

    private final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true";
    private final String user = "root";
    private final String password = "123456";

    public void connect() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接mysql
            conn = DriverManager.getConnection(url, user, password);
            // 编写sql
            String sql = "insert into person VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            // 预编译sql
            preparedStatement = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            Person person = new Person();
            long startTime = System.currentTimeMillis();

            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setLong(1, i);
                preparedStatement.setString(2, "Tom" + i);
                preparedStatement.setInt(3, 1 + i);
                preparedStatement.setBigDecimal(4, new BigDecimal(i));
                preparedStatement.setString(5, "打游戏" + i);
                preparedStatement.setString(6, "上海第" + i + "弄");
                preparedStatement.setInt(7, 1);
                preparedStatement.setString(8, "133333333" + i);
                preparedStatement.setString(9, i + "@aliyun.com");
                preparedStatement.setDate(10, new Date(System.currentTimeMillis()));
                preparedStatement.setDate(11, new Date(System.currentTimeMillis()));
                // 添加到同一个批处理中
                preparedStatement.addBatch();
            }
            // 执行批处理
            preparedStatement.executeBatch();
            // 提交事务
            conn.commit();
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCUtils jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
    }
}
