package com.qianfan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qianfan.mapper")
@SpringBootApplication
public class WinWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinWebApplication.class, args);
	}
}
