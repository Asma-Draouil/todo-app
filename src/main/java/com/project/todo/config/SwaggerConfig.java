package com.project.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.todo.utils.Constants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder().description("")
						.title("Todo list Api Documentation")
						.version("1.0")
						.description("Api Documentation")
						.build()
						)
				.groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.projet.todo"))
				.paths(PathSelectors.ant(Constants.APP_ROOT + "/**"))
				.build();
	}

}
