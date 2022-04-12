package sanqi.com.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageSize {
    public static void main(String[] args) throws IOException {
        File picture = new File("C:\\Users\\Administrator\\Desktop\\main.jpg");
        File picture2 = new File("C:\\Users\\Administrator\\Desktop\\5.jpg");

            BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
            BufferedImage sourceImg2 = ImageIO.read(new FileInputStream(picture2));
            String size = String.format("%.1f", picture.length()/(1024.0*1024.0));
            String size2 = String.format("%.1f", picture2.length()/(1024.0*1024.0));
        System.out.println("图片大小："+(Double.valueOf(size)+Double.valueOf(size2)));
            System.out.println( Double.valueOf(size)+Double.valueOf(size2)<1.0?"小于1M":"大于1M");// 源图大小
            System.out.println(sourceImg.getWidth()); // 源图宽度
            System.out.println(sourceImg.getHeight()); // 源图高度
            System.out.println(sourceImg2.getWidth()); // 源图宽度
            System.out.println(sourceImg2.getHeight()); // 源图高度


    }

}
class v{
    public static void main(String[] args) {
        File picture = new File("C:\\Users\\Administrator\\Desktop\\main.jpg");
        BufferedImage bi;
        ByteArrayOutputStream bos;
        try {
            bi = ImageIO.read(new FileInputStream(picture));
            bos =new ByteArrayOutputStream();
            ImageIO.write(bi,"jpg",bos);
            byte[] bytes = bos.toByteArray();
            System.out.println(bytes.length);
//                user.setImage(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
