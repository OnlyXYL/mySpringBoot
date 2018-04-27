package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.service.ModelRedisCacheService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Resource
    private ModelRedisCacheService modelRedisCacheService;

    /**
     * 测试redis
     *
     * @param params
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/23
     */
    @RequestMapping(value = "/{params}", method = RequestMethod.GET)
    public String testRedis(@PathVariable String params) {

        modelRedisCacheService.setCacheObject("redis", params);

        String redis = modelRedisCacheService.getCacheObject("redis");

        return redis;
    }
}
