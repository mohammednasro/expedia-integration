package com.digisolfze.expedia.config;
import java.util.Map;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuration class for Swagger/OpenAPI documentation.
 * This class provides the OpenAPI specifications and customizes the API documentation for the Expedia Integration API.
 * It defines the API metadata, version, contact details, license information, and external documentation links.
 * 
 * @author Mohammed Nasro
 */
@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

	/**
     * Defines the OpenAPI documentation metadata for the Expedia Integration API.
     * This includes the API title, description, version, license, and contact details.
     * It also includes a link to external documentation for the Expedia API integration.
     *
     * @return OpenAPI object containing API metadata and external documentation links.
     */
    @Bean
    public OpenAPI expediaIntegrationOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Expedia Integration API")
                        .description("RESTful API for integrating with Expedia to search for package offers and persist deal details in the database.")
                        .version("1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://digisolfze.com/"))
                        .contact(new Contact()
                                .name("Mohammed Nasro") 
                                .url("https://www.linkedin.com/in/mohammed-nasro-6b217969/") 
                                .email("mohammed.t.nasro@gmail.com") 
                                .extensions(Map.of("x-company", "Powered by Digisolfze company","x-company-link","https://digisolfze.com/","x-ui-link", "http://localhost:8080/index.html"))) 
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Expedia API Integration Documentation")
                        .url("https://docs.digisolfze.com/expedia-integration"));
    }

    /**
     * Configures and returns the API grouping for version 1 of the Expedia Integration API.
     * This grouping includes all endpoints that match the `/v1/**` path pattern.
     *
     * @return GroupedOpenApi object for version 1 of the Expedia Integration API.
     */
    @Bean
    public GroupedOpenApi expediaIntegrationApiV1() {
        return GroupedOpenApi.builder()
                .group("Expedia API v1")
                .pathsToMatch("/v1/**")
                .build();
    }
}
