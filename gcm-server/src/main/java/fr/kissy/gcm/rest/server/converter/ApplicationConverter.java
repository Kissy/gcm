package fr.kissy.gcm.rest.server.converter;

import fr.kissy.gcm.rest.server.dto.ApplicationDTO;
import fr.kissy.gcm.rest.server.model.Application;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class ApplicationConverter {
    /**
     * Convert an Application to an ApplicationDTO.
     *
     * @param application The Application to convert.
     * @return The ApplicationDTO created.
     */
    public ApplicationDTO toDto(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setId(application.getId());
        applicationDTO.setApiKey(application.getApiKey());
        applicationDTO.setDate(application.getDate());
        return applicationDTO;
    }

    /**
     * Convert an ApplicationDTO to an Application.
     *
     * @param applicationDTO The ApplicationDTO to convert.
     * @return The Application created.
     */
    public Application fromDto(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setId(applicationDTO.getId());
        application.setApiKey(applicationDTO.getApiKey());
        application.setDate(applicationDTO.getDate());
        return application;
    }
}
