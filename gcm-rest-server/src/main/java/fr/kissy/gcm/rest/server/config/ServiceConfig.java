package fr.kissy.gcm.rest.server.config;

import fr.kissy.gcm.rest.server.service.ApplicationService;
import fr.kissy.gcm.rest.server.service.DeviceService;
import fr.kissy.gcm.rest.server.service.DevicesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guillaume Le Biller
 */
@Configuration
public class ServiceConfig {
    @Bean
    public ApplicationService applicationService() {
        return new ApplicationService();
    }
    @Bean
    public DeviceService deviceService() {
        return new DeviceService();
    }
    @Bean
    public DevicesService devicesService() {
        return new DevicesService();
    }
}
