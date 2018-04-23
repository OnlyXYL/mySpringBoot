package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.model.SCUser;
import com.bmsmart.spring.boot.springboot.service.ModelRedisCacheService;
import com.bmsmart.spring.boot.springboot.service.ScUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @RestController 就是@Controller+@ResponseBody组合，支持RESTful访问方式，返回结果都是json字符串
 */
@RestController
public class ScUserController {

    @Resource
    private ScUserService scUserService;

    @Resource
    private ModelRedisCacheService modelRedisCacheService;

    /**
     * {
     *
     * @param userId
     * @return
     * @RequestMapping(value="/{user}", method=RequestMethod.GET)
     * public User getUser(@PathVariable Long user) {
     * // ...
     * }
     */

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public SCUser getUser(@PathVariable String userId) {

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("userId", userId);

        SCUser user = scUserService.getUser(hashMap);

        return user;
    }

    /**
     * 测试redis
     *
     * @param params
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/23
     */
    @RequestMapping(value = "/redis/{params}", method = RequestMethod.GET)
    public String testRedis(@PathVariable String params) {

        modelRedisCacheService.setCacheObject("redis", params);

        String redis = modelRedisCacheService.getCacheObject("redis");

        return redis;
    }

}
