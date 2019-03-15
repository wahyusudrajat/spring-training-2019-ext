package com.erfinfeluzy.training;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erfinfeluzy.training.spring.soap.CustomerSoapService;

@Configuration
public class SOAPConfig {
	
	@Value("${soap.producer.endpoint}")
	private String endpoint;
	

	/** SOAP consumer **/
	
	@Bean(name = "client")
	public CustomerSoapService customerServiceProxy() {
	    return (CustomerSoapService) proxyFactoryBean().create();
	}
	
	@Bean
	public JaxWsProxyFactoryBean proxyFactoryBean() {
	    JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
	    proxyFactory.setServiceClass(CustomerSoapService.class);
	    proxyFactory.setAddress(endpoint);
	    return proxyFactory;
	}
	
}
