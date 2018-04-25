package com.bmsmart.spring.boot.springboot.controller;

import com.bmsmart.spring.boot.springboot.config.RemoteProperties;
import com.bmsmart.spring.boot.springboot.exception.BusinessException;
import com.bmsmart.spring.boot.springboot.model.JsonResult;
import com.bmsmart.spring.boot.springboot.model.SCUser;
import com.bmsmart.spring.boot.springboot.service.ModelRedisCacheService;
import com.bmsmart.spring.boot.springboot.service.ScUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @RestController 就是@Controller+@ResponseBody组合，支持RESTful访问方式，返回结果都是json字符串
 * @Slf4j 相当于private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
 * @EnableConfigurationProperties 网上说是为了使@ConfigurationProperties 生效，但是，验证好像不同这个注解也没问题啊。。。。。。。
 * <p>
 * 如果项目中引用了spring-boot-starter-web 则可以去掉该注解。因为 spring-boot-starter-web中引用的有jackson,jackson中有@EnableConfigurationProperties，
 * 注册@EnableConfigurationProperties 的时候，会扫描所有的@ConfigurationProperties
 */
@RestController
//@EnableConfigurationProperties(RemoteProperties.class)
@Slf4j
public class ScUserController {

    @Resource
    private ScUserService scUserService;

    @Resource
    RemoteProperties remoteProperties;

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
    public String getUser(@PathVariable String userId) {

        log.debug(this.getClass().getName() + ":::这个东西怎么用？？？？:::");

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("userId", userId);

        SCUser user = scUserService.getUser(hashMap);


        String notFoundUser = "";
        if (user == null) {

            //测试读取属性文件中信息
            notFoundUser = remoteProperties.getNotFoundUser();

            JsonResult jsonResult = new JsonResult();
            jsonResult.error(remoteProperties.getBusinessErrorMsg(), this.getClass().getName());

            throw new BusinessException(jsonResult);
        }
        return notFoundUser;
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
