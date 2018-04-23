package com.bmsmart.spring.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *    spring boot 启动类
 * @author XiaYaLing
 * @date 2018/4/12
 * @param
 * @return
 */

/**
 * 就是@SpringBootConfiguration+@EnableAutoConfiguration+
 * @ComponentScan等组合在一下，非常简单，使用也方便
 */
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
