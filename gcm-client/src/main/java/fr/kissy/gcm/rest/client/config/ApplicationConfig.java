package fr.kissy.gcm.rest.client.config;

import fr.kissy.module.rest.config.RestTemplateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Guillaume <lebiller@fullsix.com>
 */
@Configuration
@PropertySource("classpath:fr/kissy/gcm/rest/client/config/common.properties")
@Import({ResourceConfig.class, RestTemplateConfig.class})
public class ApplicationConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
