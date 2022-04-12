package sanqi.com.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DataUtil {
	//生成主键id
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	/**
	 * 将信息进行md5算法处理
	 * @param msg 明文
	 * @return 加密后的信息
	 */
	public static String md5(String msg){
		try {
			//将密码采用md5算法处理
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] output = md.digest(msg.getBytes());
            //采用Base64算法将加密后的字节信息转成字符串
			return Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	

}
