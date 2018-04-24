package com.bmsmart.spring.boot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * spring boot demo
 *
 * @author XiaYaLing
 * @date 2018/4/12
 * @param
 * @return
 */

/**
 * @RestController 就是@Controller+@ResponseBody组合，支持RESTful访问方式，返回结果都是json字符串
 */
@Controller
public class HelloWorldController {

/*
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }
*/


}
