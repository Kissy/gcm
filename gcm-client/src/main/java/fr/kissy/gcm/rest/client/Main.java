package fr.kissy.gcm.rest.client;

import fr.kissy.gcm.rest.client.config.ApplicationConfig;
import fr.kissy.gcm.rest.client.dto.ApplicationDTO;
import fr.kissy.gcm.rest.client.resource.ApplicationResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Guillaume <lebiller@fullsix.com>
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationResource bean = applicationContext.getBean(ApplicationResource.class);
        ApplicationDTO applicationDTO = bean.getId("day9-tv");
        System.out.println(applicationDTO.getApiKey());
    }
}
