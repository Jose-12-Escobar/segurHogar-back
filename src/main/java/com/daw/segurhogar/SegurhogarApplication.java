package com.daw.segurhogar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
@EnableJpaAuditing
public class SegurhogarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurhogarApplication.class, args);
	}

    @Bean
    OpenAPI springSegurHogarAPI() {
    	return new OpenAPI()
    			.info(new Info()
    					.title("SegurHogar API")
    					.description("API Rest para el control de seguros del hogar")
    					.version("v0.0.1")
    					.termsOfService("http://swagger.io/terms/")
    					.license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
    
}
