package com.dkv.configuration.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class LoggerConfig {

    private final static Logger logger = LogManager.getLogger(LoggerConfig.class);

    @Bean
    @Profile("dev")
    public LoggerContext loggerDevContext() {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:log4j2/log4j2-dev.properties");
            // this will force a reconfiguration
            context.setConfigLocation(file.toURI());
        } catch (FileNotFoundException e) {
            logger.error(e.getStackTrace());
        }
        return context;
    }
}
