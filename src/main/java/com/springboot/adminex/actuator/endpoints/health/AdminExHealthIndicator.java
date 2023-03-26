package com.springboot.adminex.actuator.endpoints.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AdminExHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        if ("adminex".equals("adminex")) {
            builder.up();
            map.put("status", "ok");
        } else {
            builder.status(Status.OUT_OF_SERVICE);
            map.put("error", "no");
        }
        builder.withDetail("code", 100);
        builder.withDetails(map);
    }
}
