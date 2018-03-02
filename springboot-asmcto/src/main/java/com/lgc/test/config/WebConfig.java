package com.lgc.test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.alibaba.druid.support.http.StatViewServlet;

@Configurable
public class WebConfig {
	
	/*config:context-param, servlet, filter, listen*/
	@Bean
	public ServletContextInitializer initializer() {
	    return new ServletContextInitializer() {

			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter("log4jConfigLocation", "classes/log4j.properties");
				servletContext.addListener("org.springframework.web.util.Log4jConfigListener");
				servletContext.addListener("org.springframework.web.util.IntrospectorCleanupListener");
			}
	    	
	    };
	}
	
	@Bean(name="druidStatView")
	public ServletRegistrationBean druidStatView(){
		ServletRegistrationBean servletReg = new ServletRegistrationBean();
		servletReg.addUrlMappings("/druid/*");
		servletReg.setServlet(new StatViewServlet());
		return servletReg;
	}
	
	@Bean(name="characterEncodingFilter") 
    public FilterRegistrationBean characterEncodingFilter(){
        FilterRegistrationBean filterReg = new FilterRegistrationBean();  
        filterReg.addInitParameter("encoding", "utf-8");
        filterReg.addUrlPatterns("/*");  
        filterReg.setFilter(new CharacterEncodingFilter());  
        return filterReg;
	}
}
