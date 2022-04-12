package sanqi.com.test.redis.test;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService{

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean setValue(String key, String value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key, 1, TimeUnit.HOURS); // 这里指的是1小时后失效
        return false;
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.get(key);
        return null;
    }
}
