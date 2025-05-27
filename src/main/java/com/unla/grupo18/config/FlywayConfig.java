package com.unla.grupo18.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .load();
    }

    @Bean
    CommandLineRunner run(Flyway flyway) {
        return args -> {
            flyway.migrate();
        };
    }
}
