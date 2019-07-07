package com.skcomms.dev.zuul;

import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@RemoteApplicationEventScan
@SpringBootApplication
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

  @PostConstruct
  public void init() {

    FilterLoader.getInstance().setCompiler(new GroovyCompiler());

    String root = System.getProperty("zuul.filters.root", "./filters/");
    if (root.length() > 0 && !root.endsWith(File.separator))
      root = root + File.separator;

    try {
      FilterFileManager.setFilenameFilter(new GroovyFileFilter());
      FilterFileManager.init(10, root + "pre", root + "route", root + "post");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
