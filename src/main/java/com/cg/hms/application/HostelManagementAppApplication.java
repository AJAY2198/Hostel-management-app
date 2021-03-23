package com.cg.hms.application;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@SpringBootApplication(scanBasePackages = "com.cg.hms")
@EntityScan(basePackages = "com.cg.hms.entity")
@EnableJpaRepositories(basePackages = "com.cg.hms.repository")
@EnableOpenApi

public class HostelManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelManagementAppApplication.class, args);
	}
	
	@Bean
	  public Docket openApiAdmin() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("admin")
	        .select()
	        .paths(productPaths())
	        .build();
	  }

	  private Predicate<String> productPaths() {
	    return regex(".*/admin/.*");
	  }
	  @Bean
	  public Docket openApiwarden() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("warden")
	        .select()
	        .paths(productPaths2())
	        .build();
	  }

	  private Predicate<String> productPaths2() {
	    return regex(".*/warden/.*");
	  }
	  @Bean
	  public Docket openApiUser() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("student")
	        .select()
	        .paths(productPaths3())
	        .build();
	  }

	  private Predicate<String> productPaths3() {
	    return regex(".*/student/.*");
	  }

	  @Bean
	  public Docket openApiUser4() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("login")
	        .select()
	        .paths(productPaths4())
	        .build();
	  }

	  private Predicate<String> productPaths4() {
	    return regex(".*/login/.*");
	  }
}
