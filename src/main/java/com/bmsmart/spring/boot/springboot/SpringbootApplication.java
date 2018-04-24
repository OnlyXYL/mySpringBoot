package com.bmsmart.spring.boot.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
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
 */
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class SpringbootApplication extends SpringBootServletInitializer {

  /*  public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}