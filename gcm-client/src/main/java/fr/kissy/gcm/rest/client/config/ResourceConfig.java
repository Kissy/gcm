package fr.kissy.gcm.rest.client.config;

import fr.kissy.gcm.rest.client.resource.ApplicationResource;
import fr.kissy.module.rest.config.AbstractResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
@Configuration
public class ResourceConfig extends AbstractResourceConfig {
    @Bean
    public ApplicationResource applicationResource() {
        return (ApplicationResource) getResourceHandlerProxy(ApplicationResource.class);
    }
}