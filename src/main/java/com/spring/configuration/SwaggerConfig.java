package com.spring.configuration;

import java.util.Arrays;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;

import com.spring.service.resource.CalculatorResource;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan(basePackageClasses = {
    CalculatorResource.class
})
public class SwaggerConfig implements EnvironmentAware {
 
    @Bean
    public Docket detalheApi() {
 
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
        docket
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.spring.service.resource"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(this.informacoesApi().build())
        .useDefaultResponseMessages(false)
        .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())));
 
        return docket;
    }

 
    private ApiInfoBuilder informacoesApi() {
 
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
        apiInfoBuilder.title("Calculator - Diguya Dev");
        apiInfoBuilder.description("Exemple API com Design patterns Enum");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Use com moderação.");
        apiInfoBuilder.license("Licença - Food Source");
        apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/diego-ceccon/");
        apiInfoBuilder.contact(this.contato());
 
        return apiInfoBuilder;
 
    }
    private Contact contato() {
 
        return new Contact(
                "diegoceccon@outlook.com",
                "Diego Ceccon de Souza", 
                "https://www.linkedin.com/in/diego-ceccon/");
    }

    @Override
    public void setEnvironment(Environment environment) {
    }
}