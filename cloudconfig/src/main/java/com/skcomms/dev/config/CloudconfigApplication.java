package com.skcomms.dev.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudconfigApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudconfigApplication.class, args);
  }

}
