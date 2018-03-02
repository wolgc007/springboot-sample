package com.lgc.test.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.PLMSQLSessionFactoryBean;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"}, encoding="utf-8", ignoreResourceNotFound=true) 
public class DaoConfig {
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.pwd}")
	private String pwd;
	
	@Value("${jdbc.alias}")
	private String alias;
	
	@Value("${jdbc.minIdle}")
	private Integer minIdle;
	
	@Value("${jdbc.maxIdle}")
	private Integer maxIdle;
	
	@Value("${jdbc.maxWait}")
	private Integer maxWait;
	
	@Value("${jdbc.maxActive}")
	private Integer maxActive;
	
	@Value("${jdbc.initialSize}")
	private Integer initialSize;
	
	@Value("${jdbc.validationQuery}")
	private String validationQuery;
	
	@Value("${jdbc.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	
	@Value("${jdbc.filters}")
	private String filter;
	
	@Bean(name = "oracleDataSource", initMethod = "init", destroyMethod = "close")
	@Primary
	public DataSource  oracleDataSource() throws SQLException{
	    DruidDataSource dataSource = new DruidDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(username);
	    dataSource.setPassword(pwd);
	    dataSource.setFilters(filter);
	    dataSource.setInitialSize(initialSize);
	    dataSource.setMaxActive(maxActive);
	    dataSource.setValidationQuery(validationQuery);
	    dataSource.setPoolPreparedStatements(poolPreparedStatements);
	    return dataSource;
	}
	
	@Bean(name = "sessionFactory")
	public SqlSessionFactory sessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource) throws Exception{
		String configLocation = "classpath:Mybatis-*.xml";
		String mapperLocations = "classpath*:com/lgc/test/**/sqlmap_*.xml";
		SqlSessionFactoryBean factoryBean = new PLMSQLSessionFactoryBean();
		factoryBean.setDataSource(oracleDataSource);
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setConfigLocation( resolver.getResource(configLocation));
		factoryBean.setMapperLocations(resolver.getResources(mapperLocations));
		return factoryBean.getObject();
	}
	
	@Bean(name = "sqlSession")
	public SqlSession sqlSession(SqlSessionFactory sessionFactory){
		return new SqlSessionTemplate(sessionFactory);
	}
	
	@Bean(name = "mapperScannerConfigurer")
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.lgc.test");
		mapperScannerConfigurer.setAnnotationClass(MapperScan.class);
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSession");
		return mapperScannerConfigurer;
	}
	
	 @Bean(name="txManager")
	 public PlatformTransactionManager  txManager(@Qualifier("oracleDataSource") DataSource oracleDataSource) {
	        return new DataSourceTransactionManager(oracleDataSource);
	 }
	 
}
