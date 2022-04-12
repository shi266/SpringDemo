package sanqi.com.util;

import sanqi.com.entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
class tt{

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
        exportExcelUtil.addData(User.class);
        Class classz = User.class;
        System.out.println(classz);
        System.out.println("---------------------------1-1");
        Field[] fields = classz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("方法名："+field.getName()+"权限修饰符"+field.getModifiers()+"属性类型："+field.getType());
        }
        System.out.println("---------------------------1-2");
       Method[] m =  classz.getMethods();
        for (Method method : m) {
            System.out.println(method);
            System.out.println("---------------------------1-2-1");
            System.out.println(method.getName());
            System.out.println("---------------------------1-2-invoke");
        }
        System.out.println("---------------------------1-3");


//        exportExcelUtil.setEntityClass(User.class);
//
//        User user = new User();
//        Field[] fields =User.class.getDeclaredFields();
//        for (Field field : fields) {
//
//            System.out.println(field.getGenericType());
//        }


//        System.out.println(User.class.getDeclaredFields().length);
//        System.out.println( user.getRows());
    }
}

public class ExportExcelUtil {
    private  List<Object> list = new ArrayList<>();
    private  String  headerArr[] = {};
    private  List<Object> lineList = new ArrayList<>();

    public void setList(List<Object> list) {
        this.list = list;
    }



    public void setHeaderArr(String[] headerArr) {
        this.headerArr = headerArr;
    }



    public boolean exportExcel(HttpServletResponse response){



        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "ExcelName");
        HSSFCellStyle style = workbook.createCellStyle();
        //生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        //创建表格表头
//        headerArr = new String[]
//                {"账号", "ASIN", "SKU", "正移除", "库龄0-90天库存量", "库龄91-180天库存量", "库龄181-270天库存量",
//                        "库龄271-365天库存量", "库龄365+天库存量", "7天平均销量", "可卖天数", "30天平均销量", "可卖天数",
//                        "60天平均销量", "可卖天数", "90天平均销量", "可卖天数", "ASIN7天平均销量", "ASIN30天平均销量", "标准价格", "处理结果" };
        HSSFRow firstRow = sheet.createRow(0);
        //根据表头创建列
        for (int i = 0; i < headerArr.length; i++) {
            HSSFCell headercell = firstRow.createCell(i);
            headercell.setCellValue(new HSSFRichTextString(headerArr[i]));
        }
        //获取数据总条数
        //逐行写入数据
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            int k =0;
            while ( k<= 9){
                k++;
                row1.createCell(k).setCellValue(String.valueOf(lineList.get(k)));
            }
        }


        response.reset();
        response.setContentType("application/msexcel;charset=UTF-8");
        try {
            response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(("库龄详情.xls").getBytes("UTF-8"), "ISO8859_1") + "\"");
            OutputStream out = response.getOutputStream();
            workbook.write(out);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



        return true;
    }

public boolean addData(Class obj){

       Method[] methods = obj.getMethods();
    for (Method method : methods) {
        System.out.println(method.getName());
    }
    return false;
}


}
