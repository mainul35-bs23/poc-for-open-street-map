package com.dkv.configuration.log4j2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class LoggerConfig {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    private Properties log4j2Properties;

    private final static Logger logger = org.apache.logging.log4j.LogManager.getLogger(LoggerConfig.class);

    @Bean("log4j2ContextBean")
    public LoggerContext loggerDevContext() {
        logger.info("Creating logger configuration bean for dev profile");
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) org.apache.logging.log4j.LogManager.getContext(false);
        File file = null;
        try {
            file = ResourceUtils.getFile(String.format("classpath:log4j2/log4j2-%s.properties", activeProfile));
            log4j2Properties = new Properties();
            log4j2Properties.load(new FileInputStream(file));
            // this will force a reconfiguration
            context.setConfigLocation(file.toURI());
        } catch (FileNotFoundException e) {
            logger.error(e.getStackTrace());
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
        return context;
    }

    @Bean("dkvLogManager")
    @DependsOn("log4j2ContextBean")
    public DkvLogManager dkvLogManager() {
        return new DkvLogManager(log4j2Properties);
    }
}