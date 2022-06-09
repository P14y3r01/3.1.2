package test.kata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
@Configuration
public class Config {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/userpage").setViewName("userpage");
    }
}
