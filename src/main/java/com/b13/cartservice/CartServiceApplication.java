package com.b13.cartservice;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.annotation.SessionScope;

import com.b13.cartservice.dto.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}
	
//	@Bean
//	@Primary
//	public EmbeddedCacheManager getManagerConfig() {
//		GlobalConfiguration gc = new GlobalConfigurationBuilder().clusteredDefault().transport()
//				.clusterName("cluster-1").addProperty("configurationFile", "jgroups-ec2.xml").build();
//		// for non-clustered
//		Configuration cfg = new ConfigurationBuilder().clustering().cacheMode(CacheMode.DIST_SYNC).memory().size(150)
//				.build();
//		
//		return new DefaultCacheManager(gc, cfg);
//		
//	}
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
	
//	@Bean
//	@SessionScope
//	public Customer customer() {
//		return new Customer();
//	}

}
