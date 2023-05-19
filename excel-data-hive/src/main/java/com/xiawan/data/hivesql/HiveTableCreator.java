package com.xiawan.data.hivesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author wenkai li
 */
public class HiveTableCreator {
    public static void createEmployeesTable() throws ClassNotFoundException, SQLException {
        try {
            // 注册驱动程序并创建驱动程序实例
            Class.forName("org.apache.hive.jdbc.HiveDriver");

            // 获取连接
            try (Connection connection = DriverManager.getConnection("jdbc:hive2://192.168.31.240:10000/pretreatment", "root", "root");
                 Statement statement = connection.createStatement()) {

                // 表名和列名
                String tableName = "employees";
                String idCol = "id";
                String nameCol = "name";
                String ageCol = "age";
                String genderCol = "gender";
                String salaryCol = "salary";

                // 如果存在则删除表
                statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);

                // 建表
                String createTableQuery = "CREATE TABLE " + tableName + " (" +
                        idCol + " INT, " +
                        nameCol + " STRING, " +
                        ageCol + " INT, " +
                        genderCol + " STRING, " +
                        salaryCol + " DOUBLE" +
                        ")";
                statement.executeUpdate(createTableQuery);

                // 显示表
                System.out.println("Table created: " + tableName);

            } catch (SQLException e) {
                // 错误处理：记录错误日志或返回错误信息
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // 错误处理：记录错误日志或返回错误信息
            e.printStackTrace();
        }
    }
}
