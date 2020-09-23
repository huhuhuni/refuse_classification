package com.huni;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@MapperScan("com.huni.Mapper")
public class LajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LajiApplication.class, args);

	}

}
