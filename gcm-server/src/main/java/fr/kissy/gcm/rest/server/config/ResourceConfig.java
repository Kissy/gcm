package fr.kissy.gcm.rest.server.config;

import fr.kissy.gcm.rest.server.resource.DeviceResource;
import fr.kissy.gcm.rest.server.resource.DevicesResource;
import fr.kissy.gcm.rest.server.resource.ApplicationResource;
import fr.kissy.module.rest.config.AbstractResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guillaume Le Biller
 */
@Configuration
public class ResourceConfig extends AbstractResourceConfig {
    @Bean
    public ApplicationResource applicationResource() {
        return new ApplicationResource();
    }
    @Bean
    public DeviceResource deviceResource() {
        return new DeviceResource();
    }
    @Bean
    public DevicesResource devicesResource() {
        return new DevicesResource();
    }
}
