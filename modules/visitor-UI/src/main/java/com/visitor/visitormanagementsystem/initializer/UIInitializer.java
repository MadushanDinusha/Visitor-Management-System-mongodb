package com.visitor.visitormanagementsystem.initializer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:system.properties")
@ComponentScan({"com.visitor.visitormanagementsystem"})
public class UIInitializer extends SpringBootServletInitializer {


//    @PostConstruct
//    private void init() {
//    }
//
//    @PreDestroy
//    private void destry() {
//    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UIInitializer.class);
    }

}


