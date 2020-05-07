package org.acelerit.config.dbconfig;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database")
public class AppConfigurationDev extends DatabaseConfiguration {
}