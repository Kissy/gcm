package fr.kissy.gcm.rest.server.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import fr.kissy.gcm.rest.server.dto.DeviceDTO;
import fr.kissy.gcm.rest.server.service.DevicesService;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
@Api("/{application}/devices")
@Path("/{application}/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DevicesResource {
    @Autowired
    private DevicesService devicesService;

    @GET
    @ApiOperation(value = "Get the list of registered devices for an application")
    @ElementClass(response = DeviceDTO.class)
    public List<DeviceDTO> list(@PathParam("application") final String application) {
        return devicesService.list(application);
    }

    @POST
    @Path("/send")
    @ApiOperation(value = "Send GCM messages to all devices for an application")
    public void send(@PathParam("application") final String application) {
        devicesService.send(application);
    }
}
