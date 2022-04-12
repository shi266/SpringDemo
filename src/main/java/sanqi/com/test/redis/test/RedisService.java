package sanqi.com.test.redis.test;

public interface RedisService {

    boolean setValue(String key,String value);
    // 获取元素
    Object getValue(String key);

}
