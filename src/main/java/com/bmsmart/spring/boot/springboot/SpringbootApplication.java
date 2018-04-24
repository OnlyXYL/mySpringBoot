package com.bmsmart.spring.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * spring boot 启动类
 *
 * @author XiaYaLing
 * @date 2018/4/12
 * @param
 * @return
 */

/**
 * 就是@SpringBootConfiguration+@EnableAutoConfiguration+
 *
 * @ComponentScan等组合在一下，非常简单，使用也方便
 * @ServletComponentScan扫描Servlet组件时 ,
 * Servlet、过滤器和监听器可以是通过@WebServlet、@WebFilter和@WebListener自动注册
 */
@ServletComponentScan
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
