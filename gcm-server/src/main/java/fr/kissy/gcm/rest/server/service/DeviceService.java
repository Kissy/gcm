package fr.kissy.gcm.rest.server.service;

import fr.kissy.gcm.rest.server.converter.DeviceConverter;
import fr.kissy.gcm.rest.server.repository.DeviceRepository;
import fr.kissy.gcm.rest.server.dto.DeviceDTO;
import fr.kissy.gcm.rest.server.model.Application;
import fr.kissy.gcm.rest.server.model.Device;
import fr.kissy.gcm.rest.server.repository.ApplicationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class DeviceService {
    @Autowired
    private DeviceConverter deviceConverter;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public Device create(String application, DeviceDTO deviceDTO) {
        Application applicationObj = validateApplication(application);

        Device device = deviceConverter.fromDto(deviceDTO);
        device.setApplication(applicationObj.getId());
        device.setDate(new Date());
        deviceRepository.save(device);
        return device;
    }

    public DeviceDTO read(String application, String id) {
        validateApplication(application);

        Device device = deviceRepository.findOne(id);
        if (device == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(StringUtils.EMPTY).build());
        }

        return deviceConverter.toDto(device);
    }

    public DeviceDTO update(String application, DeviceDTO deviceDTO) {
        validateApplication(application);

        Device device = deviceRepository.findByApplication(application, deviceDTO.getId());
        if (device == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(StringUtils.EMPTY).build());
        }

        device.setRegistration(deviceDTO.getRegistration());
        device = deviceRepository.save(device);
        return deviceConverter.toDto(device);
    }

    public void delete(String application, String id) {
        validateApplication(application);

        deviceRepository.delete(id);
    }

    private Application validateApplication(String application) {
        Application applicationObj = applicationRepository.findOne(application);
        if (application == null || StringUtils.isBlank(applicationObj.getApiKey())) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return applicationObj;
    }
}
