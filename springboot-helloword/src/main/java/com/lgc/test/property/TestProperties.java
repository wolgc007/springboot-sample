package com.lgc.test.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/*@ConfigurationProperties*/
public class TestProperties {
	
	@Value("${test.name}")
	private String name;
	
	@Value("${test.content}")
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "name : "+name+"\tcontent : "+content;
	}
	
}
