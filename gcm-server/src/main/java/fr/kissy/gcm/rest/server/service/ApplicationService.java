package fr.kissy.gcm.rest.server.service;

import fr.kissy.gcm.rest.server.converter.ApplicationConverter;
import fr.kissy.gcm.rest.server.dto.ApplicationDTO;
import fr.kissy.gcm.rest.server.model.Application;
import fr.kissy.gcm.rest.server.repository.ApplicationRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class ApplicationService {
    @Autowired
    private ApplicationConverter applicationConverter;
    @Autowired
    private ApplicationRepository applicationRepository;

    public Application create(ApplicationDTO applicationDTO) {
        Application application = applicationConverter.fromDto(applicationDTO);
        application.setDate(new Date());
        applicationRepository.save(application);
        return application;
    }
    public ApplicationDTO read(String id) {
        Application application = applicationRepository.findOne(id);
        if (application == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(StringUtils.EMPTY).build());
        }
        return applicationConverter.toDto(application);
    }

    public ApplicationDTO update(ApplicationDTO applicationDTO) {
        Application application = applicationRepository.findOne(applicationDTO.getId());
        if (application == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(StringUtils.EMPTY).build());
        }

        application.setApiKey(applicationDTO.getApiKey());
        return applicationConverter.toDto(applicationRepository.save(application));
    }

    public void delete(String id) {
        Application application = applicationRepository.findOne(id);
        if (application == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(StringUtils.EMPTY).build());
        }

        applicationRepository.delete(application);
    }

}
