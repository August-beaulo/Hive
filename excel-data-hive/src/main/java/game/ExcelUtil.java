package game;

import java.util.List;
import java.util.Map;

public class ExcelUtil {
    //读取本地Excel
    public static void readExcel(){
        String path = "C:\\Users\\Administrator\\Desktop\\test.xlsx";
        String sheetName = "Sheet1";
                    String[] columns = {"A","B","C"};
        String[] columnNames = {"姓名","年龄","成绩"};
        List<Map<String, Object>> list = ExcelUtil.readExcel(path, sheetName, columns);
        System.out.println(list);
    }

    public static List<Map<String, Object>> readExcel(String path, String sheetName, String[] columns) {
        return null;
    }
}
