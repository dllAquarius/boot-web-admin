package com.aquarius.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.aquarius.admin.mapper") 进行扫描，使得在Mapper接口不需要在添加@Mappper注解
@MapperScan("com.aquarius.admin.mapper")
//@ServletComponentScan(basePackages = "com.aquarius.admin")
@SpringBootApplication
public class BootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }

}
