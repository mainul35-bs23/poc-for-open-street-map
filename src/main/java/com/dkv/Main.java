package com.dkv;

import com.dkv.configuration.log4j2.DkvLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Main extends SpringBootServletInitializer implements CommandLineRunner {

//    private DkvLogManager dkvLogManager  = DkvLogManager.getLogManager();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(Main.class);
    }


}
