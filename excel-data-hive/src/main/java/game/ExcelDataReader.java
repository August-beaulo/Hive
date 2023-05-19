package game;

import java.util.List;
import java.util.Map;

public class ExcelDataReader {
    //读取本地Excel
    //Excel本地路径
    //Excel表名
    //Excel列名
    //Excel列名中文名
    //返回List<Map<String, Object>>
    public static void readExcel(){
        String path = "C:\\Users\\Administrator\\Desktop\\test.xlsx";
        String sheetName = "Sheet1";
        String[] columns = {"A","B","C"};
        String[] columnNames = {"姓名","年龄","成绩"};
        List<Map<String, Object>> list = ExcelUtil.readExcel(path, sheetName, columns);
        System.out.println(list);
    }

}
