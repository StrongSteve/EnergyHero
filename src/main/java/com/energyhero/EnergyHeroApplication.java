package com.energyhero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class EnergyHeroApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(EnergyHeroApplication.class);

    @Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(EnergyHeroApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnergyHeroApplication.class);
    }

}
