package com.skcomms.dev.api.common.config;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.cloud.client.loadbalancer.AsyncRestTemplateCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {


  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setRequestFactory(clientHttpRequestFactory());
    return restTemplate;
  }

  private ClientHttpRequestFactory clientHttpRequestFactory() {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setConnectTimeout(3000);
    factory.setReadTimeout(3000);
    factory.setHttpClient(
        HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(50).build());
    return factory;
  }


}
