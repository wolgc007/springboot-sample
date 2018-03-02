package com.lgc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.lgc.test.property.TestProperties;

/**
 * Hello world!
 *
 */

@SpringBootApplication
/**@EnableConfigurationProperties*/
public class Appliacation implements CommandLineRunner 
{
	@Autowired
	TestProperties testProperties;
	
    public static void main(String[] args) {
        /* 程序启动入口
         * 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
         */
        SpringApplication.run(Appliacation.class,args);
    }

	public void run(String... args) throws Exception {
		System.out.println("\n" + testProperties.toString());
        System.out.println();
	}
}
