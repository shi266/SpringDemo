package sanqi.com.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DataUtil {
	//��������id
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	/**
	 * ����Ϣ����md5�㷨����
	 * @param msg ����
	 * @return ���ܺ����Ϣ
	 */
	public static String md5(String msg){
		try {
			//���������md5�㷨����
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] output = md.digest(msg.getBytes());
            //����Base64�㷨�����ܺ���ֽ���Ϣת���ַ���
			return Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	

}
