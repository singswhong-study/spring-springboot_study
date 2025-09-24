package com.in28minutes.springboot.learnspringspringboot;

//application.properties에 적용하거나


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//중앙 집중화 된 properties관리
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
