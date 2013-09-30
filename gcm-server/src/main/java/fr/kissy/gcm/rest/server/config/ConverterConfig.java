package fr.kissy.gcm.rest.server.config;

import fr.kissy.gcm.rest.server.converter.ApplicationConverter;
import fr.kissy.gcm.rest.server.converter.DeviceConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guillaume Le Biller
 */
@Configuration
public class ConverterConfig {
    @Bean
    public ApplicationConverter applicationConverter() {
        return new ApplicationConverter();
    }
    @Bean
    public DeviceConverter deviceConverter() {
        return new DeviceConverter();
    }
}
