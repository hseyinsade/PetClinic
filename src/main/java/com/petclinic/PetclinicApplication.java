package com.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value = PetclinicProperties.class)
@ServletComponentScan
public class PetclinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetclinicApplication.class, args);
    }
}
