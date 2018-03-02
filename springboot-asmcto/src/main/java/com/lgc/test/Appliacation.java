package com.lgc.test;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@EnableTransactionManagement
@SpringBootApplication
/**@EnableConfigurationProperties*/
public class Appliacation implements TransactionManagementConfigurer
{
	@Resource(name="txManager")
    private PlatformTransactionManager oracleTxManager;
	
    public static void main(String[] args) {
        /* 程序启动入口
         * 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
         */
        SpringApplication.run(Appliacation.class,args);
    }

    
    // 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return oracleTxManager;
	}

}
