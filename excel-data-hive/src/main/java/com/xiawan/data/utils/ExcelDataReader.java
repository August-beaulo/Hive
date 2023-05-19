package com.xiawan.data.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.xiawan.data.DSM.Employees;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author wenkai li
 */
public class ExcelDataReader {

    /**
     * @param  FILE_PATH
     * @return
     * @throws IOException
     */
    public static List<Employees> readEmployeesFromExcel(String FILE_PATH) throws IOException {
        //创建一个空的employeesList，用于存储读取的Excel信息
        List<Employees> employeesList = new ArrayList<>();

        // 参数验证：检查文件路径是否为空
        if (FILE_PATH == null || FILE_PATH.isEmpty()) {
            throw new IllegalArgumentException("File path is null or empty.");
        }
        //使用filePath文件路径创建FileInputStream对象读取Excel文件
        try (FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH));
             //使用FileInputStream创建XSSFWorkbook对象表示整个Excel
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
            //获取Excel Sheet对象
            Sheet sheet = workbook.getSheetAt(0);
            //对于Excel中的每一行，创建一个新的Employees对象
            for (Row row : sheet) {
                Employees employees = new Employees();
                int cellNum = 1;
                for (Cell cell : row) {
                    try {
                        //对于每一行中的每个单元格，根据单元格的索引使用switch语句将其值赋给相应的Employees对象属性
                        switch (cellNum) {
                            case 0:
                                employees.setId((int) cell.getNumericCellValue());
                                break;
                            case 1:
                                employees.setName(cell.getStringCellValue());
                                break;
                            case 2:
                                employees.setAge((int) cell.getNumericCellValue());
                                break;
                            case 3:
                                employees.setGender(cell.getStringCellValue());
                                break;
                            case 4:
                                employees.setSalary(cell.getNumericCellValue());
                                break;
                            default:
                                break;
                        }
                        cellNum++;
                        System.out.println("读取部分成功");
                    } catch (Exception e) {
                        // 错误处理：记录错误日志或抛出自定义异常
                        System.err.println("Error processing cell at row: " + (row.getRowNum() + 1)
                                + ", column: " + (cellNum + 1) + ", " + e.getMessage());
                    }
                }
                //将填充好数据的Employees对象添加到employeesList列表中
                employeesList.add(employees);
            }
        } catch (IOException e) {
            // 错误处理：记录错误日志或抛出自定义异常
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
        //返回填充好数据的employeesList列表
        return employeesList;
    }

}
