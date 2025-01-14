package com.example.tlo.config.openapi;

import io.swagger.v3.oas.models.servers.Server;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "springdoc")
public class OpenAPIProperties {
    private String title;
    private String version;
    private String description;
    private List<Server> servers;
}
