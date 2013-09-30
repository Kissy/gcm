package fr.kissy.gcm.rest.server.converter;

import com.google.common.collect.Lists;
import fr.kissy.gcm.rest.server.dto.DeviceDTO;
import fr.kissy.gcm.rest.server.model.Device;

import java.util.List;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class DeviceConverter {
    /**
     * Convert an Device to an DeviceDTO.
     *
     * @param device The Device to convert.
     * @return The DeviceDTO created.
     */
    public DeviceDTO toDto(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId());
        deviceDTO.setRegistration(device.getRegistration());
        deviceDTO.setDate(device.getDate());
        return deviceDTO;
    }

    /**
     * Convert an DeviceDTO to an Device.
     *
     * @param deviceDTO The DeviceDTO to convert.
     * @return The Device created.
     */
    public Device fromDto(DeviceDTO deviceDTO) {
        Device device = new Device();
        device.setId(deviceDTO.getId());
        device.setRegistration(deviceDTO.getRegistration());
        device.setDate(deviceDTO.getDate());
        return device;
    }

    /**
     * Convert Devices to DeviceDTOs.
     *
     * @param devices The Devices to convert.
     * @return The DeviceDTOs created.
     */
    public List<DeviceDTO> toDto(List<Device> devices) {
        List<DeviceDTO> deviceDTOs = Lists.newArrayList();
        for (Device device : devices) {
            deviceDTOs.add(toDto(device));
        }
        return deviceDTOs;
    }
}
