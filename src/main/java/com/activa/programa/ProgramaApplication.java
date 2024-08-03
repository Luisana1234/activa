package com.activa.programa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
       }
)
public class ProgramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgramaApplication.class, args);

                }

}



