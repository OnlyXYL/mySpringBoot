package com.bmsmart.spring.boot.springboot.service;

import com.bmsmart.spring.boot.springboot.util.RedisModelPropertiesUtil;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 *    model 缓存操作服务
 * @author XiaYaLing
 * @date 2018/1/16
 * @param
 * @return
 */
public class ModelRedisCacheService extends AbstractBaseRedisCacheService{

    @Resource
    private RedisTemplate redisTemplate;

  /*  @Resource(name = "redisModelTemplateCluster")
    private RedisTemplate redisTemplateCluster;*/

    @Override
    public RedisTemplate getRedisTemplate() {
        /**
         * 判断是 redis 单节点还是集群
         */
        if (RedisModelPropertiesUtil.getProperty("model.openCluster").equals("true")) {
//            return this.redisTemplateCluster;
            return null;
        } else if(RedisModelPropertiesUtil.getProperty("model.openCluster").equals("false")){
            return this.redisTemplate;
        }
        return null;
    }
}
