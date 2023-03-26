package com.springboot.adminex.actuator.endpoints.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AdminExInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("inMavenName", "adminex");
        map.put("inMavenVersion", "0.0.1-SNAPSHOT");
        builder.withDetail("appName", "AdminEx")
                .withDetail("appVersion", "appVersion")
                .withDetails(map);
    }
}
