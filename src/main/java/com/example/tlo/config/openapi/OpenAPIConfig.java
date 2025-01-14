package com.example.tlo.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {
    private final OpenAPIProperties openAPIProperties;

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("0-all")
                .pathsToMatch("/**")
                .pathsToExclude(
                        "/sample/**",
                        "/crypto-sample/**",
                        "/database-sample/**",
                        "/endpoint-sample/**"
                )
                .build();
    }

    @Bean
    public GroupedOpenApi enterApi() {
        return GroupedOpenApi.builder()
            .group("customer")
            .pathsToMatch("/customer/**")
            .build();
    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(openAPIProperties.getTitle())
                        .version(openAPIProperties.getVersion())
                        .description(openAPIProperties.getDescription())
                ).servers(openAPIProperties.getServers());
    }
}

