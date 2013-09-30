package fr.kissy.gcm.rest.server.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import fr.kissy.gcm.rest.server.service.DeviceService;
import fr.kissy.gcm.rest.server.dto.DeviceDTO;
import fr.kissy.gcm.rest.server.model.Device;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
@Api("/{application}/device")
@Path("/{application}/device")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {
    @Autowired
    private DeviceService deviceService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a device")
    @ElementClass(response = DeviceDTO.class)
    public Response create(@PathParam("application") final String application,
                           @ApiParam(required = true) final DeviceDTO deviceDTO) {
        Device device = deviceService.create(application, deviceDTO);
        return Response.status(Response.Status.CREATED).entity(device).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Read a device")
    public DeviceDTO read(@PathParam("application") final String application,
                         @PathParam("id") final String id) {
        return deviceService.read(application, id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a device")
    public DeviceDTO update(@PathParam("application") final String application,
                           @ApiParam(required = true) final DeviceDTO deviceDTO) {
        return deviceService.update(application, deviceDTO);
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Delete a device")
    public void delete(@PathParam("application") final String application,
                           @PathParam("id") final String id) {
        deviceService.delete(application, id);
    }
}
