//package com.nt.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import io.swagger.models.Contact;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerDocConfig {
//
//	@Bean
//	public Docket createDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.nt.controller") )
//				.paths(PathSelectors.regex("/Per.*"))
//				.build();
////				.useDefaultResponseMessages(true)
////				.apiInfo(getApiInfo());
//	}
//
////	private ApiInfo getApiInfo() {
////		Contact contact=new Contact();
////		contact.setName("Aditya");
////		contact.setEmail("adityababu@gmail.com");
////		contact.setUrl("http://www.walmart.com/Olxuser");
////		return new ApiInfo("management service","Olx user registartion service","1.1 rlease","http://www.walmart.com/liecence","contact","GNU Public","http://www.apache.org/liencne/gnu");
////
////	}
//}
