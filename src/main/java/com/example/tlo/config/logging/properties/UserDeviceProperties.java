package com.example.tlo.config.logging.properties;

import lombok.Data;

@Data
public class UserDeviceProperties {
    private String name;
    private String patternRegex;
    private String versionRegex;
    private String osTag;
}
