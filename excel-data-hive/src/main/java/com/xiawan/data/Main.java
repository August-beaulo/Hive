package com.xiawan.data;

import com.xiawan.data.DSM.Employees;
import com.xiawan.data.hivesql.HiveTableCreator;
import com.xiawan.data.utils.ExcelDataReader;
import com.xiawan.data.utils.HiveDataLoader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * @author wenkai li
 */
public class Main {
    public static void main(String[] args) {
        try {
            // 读取Excel数据
            List<Employees> employeesList = ExcelDataReader.readEmployeesFromExcel("C:\\develop_work\\New\\Excel_Data\\2月子订单.xlsx");
            System.out.println("读取成功");
            // 建表
            HiveTableCreator.createEmployeesTable();
            System.out.println("建表成功");
            // 加载数据到Hive
            HiveDataLoader.loadDataToHive(employeesList);
            System.out.println("加载结束");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
