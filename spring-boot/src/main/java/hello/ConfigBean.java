package hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "com.demo")
@PropertySource("classpath:application.properties")
public class ConfigBean {
    private String name;
    private String want;
    
}