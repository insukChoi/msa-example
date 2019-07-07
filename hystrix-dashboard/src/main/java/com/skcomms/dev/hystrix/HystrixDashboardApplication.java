package com.skcomms.dev.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableHystrixDashboard
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class HystrixDashboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardApplication.class, args);
  }

}
