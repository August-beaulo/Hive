package com.xiawan.data.utils;

import com.xiawan.data.DSM.Employees;
import org.apache.hadoop.hbase.client.Connection;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.apache.hadoop.hbase.client.ConnectionFactory.createConnection;

/**
 * 使用JDBC连接Hive并进行批量插入操作
 *  @author wenkai li
 */
public class HiveDataLoader {
    /**
     * Hive数据库驱动及URL
     */
    private static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    private static final String HIVE_URL = "jdbc:hive2://192.268.31.240：10000/pretreatment";

    private static final int THREAD_POOL_SIZE = 10;

    public static void loadDataToHive (List<Employees> employeesList){
        try {
            Class.forName(HIVE_DRIVER);
            try (Connection connection = createConnection()) {
            } catch (IOException e) {

            }
        } catch (ClassNotFoundException e) {

        }
    }
    /**
     * Hive数据库驱动及URL
     *//*
    private static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    private static final String HIVE_URL = "jdbc:hive2://192.168.31.240:10000/pretreatment";

    private static final int THREAD_POOL_SIZE = 10;
    public static void loadDataToHive(List<Employees> employeesList) {
        try {
            Class.forName(HIVE_DRIVER);
            try (Connection connection = createConnection()) {

                
                // 设置事务隔离级别为可重复读
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                connection.setAutoCommit(false);

                String sql = "INSERT INTO employees(id, name, age, gender, salary) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    ExecutorService executorService = Executors.newFixedThreadPool(10); // 根据需要设置线程池大小

                    for (Employees employee : employeesList) {
                        executorService.submit(() -> {
                            try {
                                insertEmployee(connection, employee);

                                System.out.println("插入成功");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    executorService.shutdown();
                    while (!executorService.isTerminated()) {
                        // 等待所有任务执行完成
                    }

                    //connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                    //connection.rollback();
                    System.out.println("回滚");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 创建连接
     * @return
     * @throws SQLException
     *//*
    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(HIVE_URL, "root", "root");
    }
    private static void insertEmployee(Connection connection, Employees employee) throws SQLException {
        String sql = "INSERT overwrite  employees(id, name, age, gender, salary) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Employees.getId());
            preparedStatement.setString(2, removeTabsAndNewlines(Employees.getName()));
            preparedStatement.setInt(3, Employees.getAge());
            preparedStatement.setString(4, removeTabsAndNewlines(Employees.getGender()));
            preparedStatement.setDouble(5, Employees.getSalary());
            //preparedStatement.executeUpdate();
            System.out.println("插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("回滚错误");
        }
    }
    private static String removeTabsAndNewlines(String value) {
        return value.replaceAll("[\\t\\n]", "");
    }
*/
}
