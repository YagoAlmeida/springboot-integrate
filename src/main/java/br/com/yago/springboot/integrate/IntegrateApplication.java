package br.com.yago.springboot.integrate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@RefreshScope
@EnableDiscoveryClient
@EnableConfigurationProperties
@SpringBootApplication
@Slf4j
@Configuration
public class IntegrateApplication {

	@Value("${mongo.uri}")
	private String mongoUri;

	@PostConstruct
	public void postConstruct() {
		log.info("MongoUri: {}", mongoUri);
	}

	public static void main(String[] args) {
		SpringApplication.run(IntegrateApplication.class, args);
	}

}