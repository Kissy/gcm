package fr.kissy.gcm.rest.server.config;

import fr.kissy.module.rest.config.RestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Guillaume Le Biller
 */
@Configuration
@Import({DatabaseConfig.class, ServiceConfig.class, ResourceConfig.class, ConverterConfig.class, RestConfig.class})
@ComponentScan("fr.kissy.gcm.rest.server.repository")
@PropertySource("classpath:fr/kissy/gcm/rest/server/common.properties")
public class ApplicationConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
