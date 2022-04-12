package sanqi.com.test;

import cn.hutool.core.util.ObjectUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateFollowSaleXml {
    public static void main(String[] args) throws IOException {
//        CreateFollowSaleXml c = new CreateFollowSaleXml();
//        System.out.println("开始创建ProductXMl");
//        c.createProductXml();
//        System.out.println("开始创建PriceXML");
//        c.createPriceXml();
//        System.out.println("开始创建InventoryXMl");
//        c.createInventoryXml();

        String a = null;
        String b = "null";
        System.out.println(ObjectUtil.isEmpty(a));
        System.out.println(ObjectUtils.isEmpty(b));


    }

    public void createProductXml() throws IOException {
        Document document = DocumentHelper.createDocument();//建立document对象，用来操作xml文件
        Element amazonEnvelopeElement = document.addElement("AmazonEnvelope");//建立根节点
        amazonEnvelopeElement.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        amazonEnvelopeElement.addAttribute(" xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
        //第一层
        Element headerElement = amazonEnvelopeElement.addElement("Header");
        Element documentVersionElement = headerElement.addElement("DocumentVersion");
        documentVersionElement.setText(String.valueOf(1.01));
        Element merchantIdentifierElement = headerElement.addElement("MerchantIdentifier");
        merchantIdentifierElement.setText("卖家ID");
        Element messageTypeElement = amazonEnvelopeElement.addElement("MessageType");
        messageTypeElement.setText("Product");
        Element purgeAndReplaceElement = amazonEnvelopeElement.addElement("PurgeAndReplace");
        purgeAndReplaceElement.setText("false");
        Element messageElement = amazonEnvelopeElement.addElement("Message");
        //第二层
        Element messageIDElement = messageElement.addElement("MessageID");
        messageIDElement.setText("1");
        Element operationTypeElement = messageElement.addElement("OperationType");
        operationTypeElement.setText("Update");
        Element productElement = messageElement.addElement("Product");
        //第三层
        Element mSKUElement = productElement.addElement("SKU");
        mSKUElement.setText("卖家sku");
        Element standardProductID = productElement.addElement("StandardProductID");
        Element standardProductIDType = standardProductID.addElement("Type");
        standardProductIDType.setText("ASIN");
        Element standardProductIDValue = standardProductID.addElement("Value");
        standardProductIDValue.setText("跟卖的ASIN");
        Element conditionElement = productElement.addElement("Condition");
        Element conditionTypeElement = conditionElement.addElement("ConditionType");
        conditionTypeElement.setText("新旧类型");
        Element descriptionDataElement = productElement.addElement("DescriptionData");
        //第四层
        Element titleElement = descriptionDataElement.addElement("Title");
        titleElement.setText("跟卖ASIN的标题");
        Element batteryElement=descriptionDataElement.addElement("Battery");
        Element areBatteriesIncludedElement=batteryElement.addElement("AreBatteriesIncluded");
        areBatteriesIncludedElement.setText("false");
        Element areBatteriesRequiredElement=batteryElement.addElement("AreBatteriesRequired");
        areBatteriesRequiredElement.setText("false");
        Element supplierDeclaredDGHZRegulationElement=descriptionDataElement.addElement("SupplierDeclaredDGHZRegulation");
        supplierDeclaredDGHZRegulationElement.setText("not_applicable");




        String savepath = "C:\\Users\\Administrator\\Desktop\\ProductTest.xml";
        File file = new File(savepath);
        if(file.exists()){
            file.delete();
            System.out.println("ProductTest，删除");
        }
        XMLWriter writer=null;
        try {
            //写入文件
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndent(true);
            format.setIndent("  ");
            format.setEncoding("UTF-8");
            writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file),"UTF-8"),format);
            writer.write(document);
            writer.flush();//立即写入
            writer.close();//关闭
            System.out.println("ProductXML写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }

    public void createPriceXml() throws IOException {

        Document document = DocumentHelper.createDocument();//建立document对象，用来操作xml文件
        Element amazonEnvelopeElement = document.addElement("AmazonEnvelope");//建立根节点
        amazonEnvelopeElement.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        amazonEnvelopeElement.addAttribute(" xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
        //第一层
        Element headerElement = amazonEnvelopeElement.addElement("Header");
        Element documentVersionElement = headerElement.addElement("DocumentVersion");
        documentVersionElement.setText(String.valueOf(1.02));
        Element merchantIdentifierElement = headerElement.addElement("MerchantIdentifier");
        merchantIdentifierElement.setText("卖家ID");
        Element messageTypeElement = amazonEnvelopeElement.addElement("MessageType");
        messageTypeElement.setText("Price");
        Element messageElement = amazonEnvelopeElement.addElement("Message");
        //第二层
        Element messageIDElement = messageElement.addElement("MessageID");
        messageIDElement.setText("1");
        Element priceElement=messageElement.addElement("Price");
        //第三层
        Element mSKUElement=priceElement.addElement("SKU");
        mSKUElement.setText("卖家sku");
        Element standardPriceElement=priceElement.addElement("StandardPrice");
        standardPriceElement.addAttribute("currency", "货币单位");

        standardPriceElement.setText(String.valueOf("标准价格"));



        String savepath = "C:\\Users\\Administrator\\Desktop\\PriceTest.xml";
        File file = new File(savepath);
        if(file.exists()){
            file.delete();
            System.out.println("PriceTest，删除");
        }
        XMLWriter writer=null;
        try {
            //写入文件
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndent(true);
            format.setIndent("  ");
            format.setEncoding("UTF-8");
            writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file),"UTF-8"),format);
            writer.write(document);
            writer.flush();//立即写入
            writer.close();//关闭
            System.out.println("PriceXML写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }

    public void createInventoryXml() throws IOException {

        Document document = DocumentHelper.createDocument();//建立document对象，用来操作xml文件
        Element amazonEnvelopeElement = document.addElement("AmazonEnvelope");//建立根节点
        amazonEnvelopeElement.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        amazonEnvelopeElement.addAttribute(" xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
        //第一层
        Element headerElement = amazonEnvelopeElement.addElement("Header");
        Element documentVersionElement = headerElement.addElement("DocumentVersion");
        documentVersionElement.setText(String.valueOf(1.01));
        Element merchantIdentifierElement = headerElement.addElement("MerchantIdentifier");
        merchantIdentifierElement.setText("卖家ID");
        Element messageTypeElement = amazonEnvelopeElement.addElement("MessageType");
        messageTypeElement.setText("Inventory");
        Element messageElement = amazonEnvelopeElement.addElement("Message");
        //第二层
        Element messageIDElement = messageElement.addElement("MessageID");
        messageIDElement.setText("1");
        Element operationTypeElement = messageElement.addElement("OperationType");
        operationTypeElement.setText("PartialUpdate");
        Element inventoryElement=messageElement.addElement("Inventory");
        //第三层
        Element mSKUElement=inventoryElement.addElement("SKU");
        mSKUElement.setText("卖家sku");
        Element fulfillmentCenterIDElement=inventoryElement.addElement("FulfillmentCenterID");
        fulfillmentCenterIDElement.setText("AMAZON_NA");
        Element lookupElement=inventoryElement.addElement("Lookup");
        lookupElement.setText("FulfillmentNetwork");
        Element switchFulfillmentToElement=inventoryElement.addElement("SwitchFulfillmentTo");
        switchFulfillmentToElement.setText("发货网络");



        String savepath = "C:\\Users\\Administrator\\Desktop\\InventoryTest.xml";
        File file = new File(savepath);
        if(file.exists()){
            file.delete();
            System.out.println("InventoryTest，删除");
        }
        XMLWriter writer=null;
        try {
            //写入文件
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndent(true);
            format.setIndent("  ");
            format.setEncoding("UTF-8");
            writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file),"UTF-8"),format);
            writer.write(document);
            writer.flush();//立即写入
            writer.close();//关闭
            System.out.println("InventoryXml写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }
}
