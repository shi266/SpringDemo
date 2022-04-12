package sanqi.com.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class CreateXMlTest {

    public static String createProductXML() throws IOException {
        Document document = DocumentHelper.createDocument();//创建document对象
        //建立根节点
        Element AmazonEnvelope = document.addElement("AmazonEnvelpoe");
                AmazonEnvelope.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
                AmazonEnvelope.addAttribute("xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
            Element Header = AmazonEnvelope.addElement("Header");
                Element DocumentVersion = Header.addElement("DocumentVersion");
                        DocumentVersion.setText(String.valueOf(1.01));
                Element MerchanIdentifier = Header.addElement("MerchanIdentifier");
                        MerchanIdentifier.setText("xxxxxxxxxx");
            Element MessageType = AmazonEnvelope.addElement("MessageType");
                    MessageType.setText("Product");
            Element PurgeAndReplace = AmazonEnvelope.addElement("PurgeAndReplace");
                    PurgeAndReplace.setText("xxxxxx");
            Element Message = AmazonEnvelope.addElement("Message");
                Element MessageID = Message.addElement("MessageID");
                        MessageID.setText(String.valueOf(1));
                Element Product = Message.addElement("Product");
                    Element SKU = Product.addElement("SKU");
                            SKU.setText("hfdsifuisdk");
                    Element Condition = Product.addElement("Condition");
                        Element ConditionType = Condition.addElement("ConditionType");
                                ConditionType.setText("New");
                    Element DescriptionData = Product.addElement("DescriptionData");
                        Element Title = DescriptionData.addElement("Title");
                                Title.setText("商品名称描述");
                        Element Brand = DescriptionData.addElement("Brand");
                                Brand.setText("品牌名");
                        Element BulletPointOne = DescriptionData.addElement("BulletPoint");
                                BulletPointOne.setText("五点描述之一");
                        Element BulletPointTwo = DescriptionData.addElement("BulletPoint");
                                BulletPointTwo.setText("五点描述之二");
                        Element BulletPointThree = DescriptionData.addElement("BulletPoint");
                                BulletPointThree.setText("五点描述之三");
                        Element BulletPointFour = DescriptionData.addElement("BulletPoint");
                                BulletPointFour.setText("五点描述之一四");
                        Element BulletPointFive = DescriptionData.addElement("BulletPoint");
                                BulletPointFive.setText("五点描述之五");
                        Element ItemDimensions = DescriptionData.addElement("ItemDimensions");
                            Element Length = ItemDimensions.addElement("Length");
                                    Length.addAttribute("unitofMeasure","CM");
                                    Length.setText(String.valueOf(6.6));
                            Element Width = ItemDimensions.addElement("Width");
                                    Width.addAttribute("unitofMeasure","CM");
                                    Width.setText(String.valueOf(7.7));
                            Element Height = ItemDimensions.addElement("Height");
                                    Height.addAttribute("unitofMeasure","CM");
                                    Height.setText(String.valueOf(8.8));
                        Element PackageDimensions =DescriptionData.addElement("PackageDimensions");
                        Element LengthOne = PackageDimensions.addElement("Length");
                                LengthOne.addAttribute("unitofMeasure","CM");
                                LengthOne.setText(String.valueOf(6.6));
                        Element WidthTwo = PackageDimensions.addElement("Width");
                                WidthTwo.addAttribute("unitofMeasure","CM");
                                WidthTwo.setText(String.valueOf(7.7));
                        Element HeightThree = PackageDimensions.addElement("Height");
                                HeightThree.addAttribute("unitofMeasure","CM");
                                HeightThree.setText(String.valueOf(8.8));
                        Element PackageWeight = DescriptionData.addElement("PackageWeight");
                                PackageWeight.addAttribute("unitofMeasure","GR");
                        Element ShippingWeight = DescriptionData.addElement("ShippingWeight");
                                ShippingWeight.addAttribute("unitofMeasure","GR");
                        Element MSRP = DescriptionData.addElement("MSRP");
                                MSRP.setText(String.valueOf(11.11));
                        Element MaxOrderQuantity = DescriptionData.addElement("MaxOrderQuantity");
                                MaxOrderQuantity.setText(String.valueOf(1));
                        Element Manufacturer = DescriptionData.addElement("Manufacturer");
                                Manufacturer.setText("xxxxxxxxxxxxxx");
                        Element MfrPartNumber = DescriptionData.addElement("MfrPartNumber");
                                MfrPartNumber.setText("yyyyyyyyyyyy");
                        Element ItemType = DescriptionData.addElement("ItemType");
                                ItemType.setText("zzzzzzzzzzzzzzzz");
                            Element Battery = DescriptionData.addElement("Battery");
                            Element AreBatteriesIncluded = Battery.addElement("AreBatteriesIncluded");
                                    AreBatteriesIncluded.setText("false");
                            Element AreBatteriesRequired = Battery.addElement("AreBatteriesRequired");
                                    AreBatteriesRequired.setText("false");
                        Element SupplierDeclaredDGHZRegulation = DescriptionData.addElement("SupplierDeclaredDGHZRegulation");
                                SupplierDeclaredDGHZRegulation.setText("kkkkkkkkkkkkkk");
//                    Element ProductData = Product.addElement("ProductData");
//                        Element CE = ProductData.addElement("CE");
//                            Element ProductType = CE.addElement("ProductType");
//                                Element ScreenProtector = ProductType.addElement("ScreenProtector");
//                                    Element CompatibleDevices = ScreenProtector.addElement("CompatibleDevices");
//                                            CompatibleDevices.setText("xxxxxxxxxxxxxx");
//                            Element ColorMap = CE.addElement("ColorMap");
//                                    ColorMap.setText("Clear");


        String savepath = "D:/DemoTest/Product_T.xml";
        File file = new File(savepath);
            if(file.exists()){
                file.delete();
                System.out.println("Product_T存在，删除");
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
            }catch (Exception e){
                e.printStackTrace();
                return "fail";
            }finally {
                if(writer!=null){
                    writer.close();
                }
            }
        return "success";
    }

    public static String createPriceXML() throws IOException {
        Document document = DocumentHelper.createDocument();
        //建立根节点
            Element AmazonEnvelope = document.addElement("AmazonEnvelope");
                    AmazonEnvelope.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
                    AmazonEnvelope.addAttribute("xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
                Element Header = AmazonEnvelope.addElement("Header");
                    Element DocumentVersion = Header.addElement("DocumentVersion");
                            DocumentVersion.setText(String.valueOf(1.01));
                    Element MerchantIdentifier = Header.addElement("MerchantIdentifier");
                            MerchantIdentifier.setText("卖家ID");
                Element MessageType = AmazonEnvelope.addElement("MessageType");
                        MessageType.setText("Price");
                Element Message = AmazonEnvelope.addElement("Message");
                    Element MessageID = Message.addElement("MessageID");
                            MessageID.setText(String.valueOf(1));
                    Element OperationType = Message.addElement("OperationType");
                            OperationType.setText("XXXXXXXXXXXXXX");
                    Element Price = Message.addElement("Price");
                        Element SKU = Price.addElement("SKU");
                                SKU.setText("YYYYYYYYYYY");
                        Element StandardPrice = Price.addElement("StandardPrice");
                                StandardPrice.addAttribute("currency","货币单位");
                                StandardPrice.setText(String.valueOf(9.99));

        String savepath = "/DemoTest/Price_T.xml";
        File file = new File(savepath);
        if(file.exists()){
            file.delete();
            System.out.println("Price_T存在，删除");
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
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
        return "success";
    }
    public static String createInventoryXML() throws IOException {
        //创建document对象
        Document document = DocumentHelper.createDocument();
        //建立根节点
            Element AmazonEnvelope = document.addElement("AmazonEnvelope");
                    AmazonEnvelope.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
                    AmazonEnvelope.addAttribute("xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");
                Element Header = AmazonEnvelope.addElement("Header");
                    Element DocumentVersion = Header.addElement("DocumentVersion");
                            DocumentVersion.setText(String.valueOf(1.01));
                    Element MerchantIdentifier = Header.addElement("MerchantIdentifier");
                            MerchantIdentifier.setText("XXXXXXXXXXXXXX");
                Element MessageType = AmazonEnvelope.addElement("MessageType");
                        MessageType.setText("Inventory");
                Element Message = AmazonEnvelope.addElement("Message");
                    Element MessageID = Message.addElement("MessageID");
                            MessageID.setText(String.valueOf(1));
                    Element OperationType = Message.addElement("OperationType");
                            OperationType.setText("Update");
                    Element Inventory = Message.addElement("Inventory");
                        Element SKU = Inventory.addElement("SKU");
                                SKU.setText("YYYYYYYYYYYYY");
                        Element FulfillmentCenterID = Inventory.addElement("FulfillmentCenterID");
                                FulfillmentCenterID.setText("ZZZZZZZZZZZZ");
                        Element Available = Inventory.addElement("Available");
                                Available.setText("true");


        String savepath = "/DemoTest/Inventory_T.xml";
        File file = new File(savepath);
        if(file.exists()){
            file.delete();
            System.out.println("Inventory_T存在，删除");
        }
        XMLWriter writer=null;
        try {
            //写入文件
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            format.setIndent("  ");
            format.setIndent(true);
            writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file),"UTF-8"),format);
            writer.write(document);
            writer.flush();//立即写入
            writer.close();//关闭
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
        return "success";
    }

    public static void main(String[] args) throws IOException {
//        System.out.println( createProductXML());
//        System.out.println( createPriceXML());
//        System.out.println( createInventoryXML());

       while (true){
           BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
           System.out.println(input.readLine());
       }
    }

}
