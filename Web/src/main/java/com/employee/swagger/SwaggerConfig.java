package com.employee.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(new BasicAuth("basicAuth"));
        return new Docket(DocumentationType.SWAGGER_2).securitySchemes(schemeList)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.employee"))
                .paths(PathSelectors.any())
                .build();
    }
	 @SuppressWarnings("unused")
	private ApiInfo getApiInfo() {
	        Contact contact = new Contact("Atif", "i dont have a blog", "");
	        return new ApiInfoBuilder()
	                .title("Employee DashBoard")
	                .description("Providing Employee Information")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
	                .contact(contact)
	                .build();
	    }
}
