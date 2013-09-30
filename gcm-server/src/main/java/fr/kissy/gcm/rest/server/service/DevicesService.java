package fr.kissy.gcm.rest.server.service;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;
import fr.kissy.gcm.rest.server.converter.DeviceConverter;
import fr.kissy.gcm.rest.server.dto.DeviceDTO;
import fr.kissy.gcm.rest.server.model.Device;
import fr.kissy.gcm.rest.server.repository.DeviceRepository;
import fr.kissy.gcm.rest.server.model.Application;
import fr.kissy.gcm.rest.server.repository.ApplicationRepository;
import fr.kissy.gcm.rest.server.task.GcmSenderTask;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class DevicesService {
    @Autowired
    private DeviceConverter deviceConverter;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ExecutorService executorService;

    public Integer send(String application) {
        Application applicationObj = applicationRepository.findOne(application);
        if (application == null || StringUtils.isBlank(applicationObj.getApiKey())) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<String> devices = deviceRepository.findAllRegistrationByApplication(application);
        if (devices.isEmpty()) {
            return 0;
        }

        executorService.execute(new GcmSenderTask(applicationObj.getApiKey(), devices));
        return devices.size();
    }

    public List<DeviceDTO> list(String application) {
        Application applicationObj = applicationRepository.findOne(application);
        if (application == null || StringUtils.isBlank(applicationObj.getApiKey())) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Device> devices = deviceRepository.findAllByApplication(application);
        return deviceConverter.toDto(devices);
    }
}
