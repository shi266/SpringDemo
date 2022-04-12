package sanqi.com.test;



import sanqi.com.entity.Excel;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadTempleteToWriteOfExcel {

    public static void excel() throws IOException, TemplateException {
        //创建configuration
        Configuration configuration = new Configuration();
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //设置数字格式
        configuration.setNumberFormat("0");
        //设置模板所存在位置路径
        configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile("classpath:"));
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        //加载模板（模板名称）
        Template template = configuration.getTemplate("excelTemp.ftl","UTF-8");
        OutputStreamWriter writer = null;

        List<Excel> list = new ArrayList<>();
        list.add(new Excel("a","b","c","v","e","f","g"));
        list.add(new Excel("a1","b1","c1","v1","e1","f1","g1"));
        list.add(new Excel("a2","b2","c2","v2","e2","f2","g2"));
        list.add(new Excel("a3","b3","c3","v3","e3","f3","g3"));
        list.add(new Excel("a4","b4","c4","v4","e4","f4","g4"));
        list.add(new Excel("a5","b5","c5","v5","e5","f5","g5"));
        Map map = new HashMap();


//            map.put("packageId",list.get(i).getPackageId());
//            map.put("shipmentId",list.get(i).getShipmentId());
//            map.put("shipmentValue",list.get(i).getShipmentValue());
//            map.put("shipmentWeight",list.get(i).getShipmentWeight());
//            map.put("packageSize",list.get(i).getPackageSize());
//            map.put("packageQuantity",list.get(i).getPackageQuantity());
//            map.put("packageColor",list.get(i).getPackageColor());
        map.put("carrierInfos",list);



        try {
            File newfile = new File("C:/Users/Administrator/Desktop/templete.xls");
            if(newfile.exists()){
                newfile.delete();
                System.out.println("已存在，先删除！");
            }
            writer = new OutputStreamWriter(new FileOutputStream(newfile),"UTF-8");
            //加载数据
            template.process(map,writer);
            writer.flush();

        }catch (Exception e){
           e.printStackTrace();
        }finally {
            writer.close();
            System.out.println("创建完成！");
        }


    }

    public static void doExcel() throws IOException {
        //创建一个Excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //创建一个sheet
        HSSFSheet sheet = workbook.createSheet();
        //设置Excel  sheet表名
        workbook.setSheetName(0,"调查表-Investigation Form");
        CellStyle style = workbook.createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);//设置前景填充样式
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());//前景填充色
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setWrapText(true);
        //创建表头 第一行
        HSSFRow row = sheet.createRow(0);
        row.setHeight((short) 1000);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(style); //cell 是 HSSFCell 对象
        cell.setCellValue("包裹调查需要按照每个包裹的单号分别填写下列信息：\r\nTracer information should be entered by ecery parcel, please record below information by package.");
        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("需要调查的包裹编号：\n" +
                "发件人姓名（shipper's name）：\n" +
                "发件人电话（shipper's phone number）： \n" +
                "发件人邮箱（shipper's mailbox）： \n" +
                "收件人姓名（consignee's name）*： \n" +
                "收件人电话（consignee's phone number）*： \n" +
                "收件人邮箱（consignee's mailbox）*： \n" +
                "收件人地址（consignee's address）： \n" +
                "货物价值（shipment value）*：  \n" +
                "货件重量（shipment weight）*：\n" +
                "" +
                "");
        cell1.setCellStyle(style);
        CellRangeAddress regioncell = new CellRangeAddress(1, 28, 0, 8);
        CellRangeAddress regionrow = new CellRangeAddress(1, 28, 0, 0);


        sheet.addMergedRegion(regioncell);
        


        
        
        
        String path = "C:/Users/Administrator/Desktop/testDemo.xls";
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
//        Writer out = new FileWriter(new File(path));
        workbook.write(file);
        System.out.println("结束");
    }


    public static void main(String[] args) throws IOException, TemplateException {
        excel();
//        doExcel();



    }

}

