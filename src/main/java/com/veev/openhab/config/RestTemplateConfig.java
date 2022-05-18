package com.veev.openhab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Value("${open-hab.uri}")
    private String baseUri;

    @Bean
    public RestTemplate openHabRestTemplate() {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUri);
        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
        restTemplate.setUriTemplateHandler(uriBuilderFactory);
        return restTemplate;
    }
}
