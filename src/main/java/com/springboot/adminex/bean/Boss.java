package com.springboot.adminex.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("person")
@Profile({"prod","dev","default"})
public class Boss implements Person {
    private String name;
    private Integer age;
}
