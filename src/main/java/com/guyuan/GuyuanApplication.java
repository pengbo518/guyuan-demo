package com.guyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 主程序
 * @version: v1.0
 * @create: 2019-07-14 14:36
 **/
@SpringBootApplication
@EnableSwagger2
public class GuyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuyuanApplication.class, args);
    }
}
