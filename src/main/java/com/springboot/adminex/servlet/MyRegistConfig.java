package com.springboot.adminex.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/my");
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
        return new FilterRegistrationBean(myFilter, myServlet());
    }

    @Bean
    public ServletListenerRegistrationBean myServletContextListener() {
        MyServletContextListener listener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(listener);
    }
}
