package com.chenqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApp {

    public  static  void  main(String[] args){

        SpringApplication.run(RegisterCenterApp.class,args);
    }
}
