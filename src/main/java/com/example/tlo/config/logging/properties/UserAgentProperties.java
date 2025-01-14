package com.example.tlo.config.logging.properties;


import lombok.Data;

import java.util.List;


@Data
public class UserAgentProperties {
    private List<UserDeviceProperties> devices;
}

