package com.bmsmart.spring.boot.springboot.service;

import com.bmsmart.spring.boot.springboot.util.RedisSessionPropertiesUtil;
import org.apache.shiro.session.Session;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 *    session缓存操作服务
 * @author XiaYaLing
 * @date 2018/1/16
 * @param
 * @return
 */
public class SessionRedisCacheService extends AbstractBaseRedisCacheService {

    @Resource(name = "redisSessionTemplateSingle")
    private RedisTemplate redisTemplateSingle;

    @Resource(name = "redisSessionTemplateCluster")
    private RedisTemplate redisTemplateCluster;

    @Override
    public RedisTemplate getRedisTemplate() {
        /**
         * 判断是 redis 单节点还是集群
         */
        if (RedisSessionPropertiesUtil.getProperty("session.openCluster").equals("true")) {
            return this.redisTemplateCluster;
        } else if (RedisSessionPropertiesUtil.getProperty("session.openCluster").equals("false")) {
            return this.redisTemplateSingle;
        }
        return null;
    }

    /**
     *    缓存session
     * @author XiaYaLing
     * @date 2018/1/16
     * @param key
     * @param session
     * @return void
     */
    public void setCacheSession(String key,Session session){
        BoundValueOperations<String, Object> sessionValueOperations = this.getRedisTemplate().boundValueOps("shiro_session_" + key);
        sessionValueOperations.set(session);
        sessionValueOperations.expire(this.getExpireTime(), TimeUnit.SECONDS);
    }

    /**
     *    获取缓存session
     * @author XiaYaLing
     * @date 2018/1/16
     * @param key
     * @return org.apache.shiro.session.Session
     */
    public Session getCacheSession(String key){

        BoundValueOperations<String, Object> sessionValueOperations = this.getRedisTemplate().boundValueOps("shiro_session_" + key);
        return (Session) sessionValueOperations.get();
    }
}
