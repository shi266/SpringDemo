package sanqi.com.test.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@Component
public class RedisUtil {

    @Resource
    private StringRedisTemplate redisTemplate;


    /**
     * 数据缓存至redis
     *
     * @param key
     * @param value
     * @return
     */
    public <K, V> void add(K key, V value) {
        try {
            if (value != null) {
                redisTemplate
                        .opsForValue()
                        .set( ""+key, JSON.toJSONString(value));
            }
        } catch (Exception e) {
            throw new RuntimeException("数据缓存至redis失败");
        }
    }


}