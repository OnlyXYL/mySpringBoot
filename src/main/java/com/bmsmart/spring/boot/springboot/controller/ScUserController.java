package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.model.SCUser;
import com.bmsmart.spring.boot.springboot.service.ScUserService;
import com.bmsmart.spring.boot.springboot.service.SessionRedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ScUserService scUserService;

    @Resource
    private SessionRedisCacheService sessionRedisCacheService;

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
     * 测试自己实现redis
     *
     * @param param
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/23
     */
    @RequestMapping(value = "/redis/{param}", method = RequestMethod.GET)
    public String testRedis(@PathVariable String param) {
        sessionRedisCacheService.setCacheObject("testRedisCluster", param);

        String testRedis = sessionRedisCacheService.getCacheObject("testRedisCluster");

        return testRedis;
    }

}
