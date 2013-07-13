package fr.kissy.gcm.rest.server.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import fr.kissy.gcm.rest.server.dto.ApplicationDTO;
import fr.kissy.gcm.rest.server.service.ApplicationService;
import fr.kissy.gcm.rest.server.model.Application;
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
@Api("/application")
@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
    @Autowired
    private ApplicationService applicationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create an application")
    @ElementClass(response = ApplicationDTO.class)
    public Response create(@ApiParam(required = true) final ApplicationDTO applicationDTO) {
        Application application = applicationService.create(applicationDTO);
        return Response.status(Response.Status.CREATED).entity(application).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Read an application")
    public ApplicationDTO read(@PathParam("id") final String id) {
        return applicationService.read(id);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update an application")
    public ApplicationDTO update(@ApiParam(required = true) final ApplicationDTO applicationDTO) {
        return applicationService.update(applicationDTO);
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Delete an application")
    public void delete(@PathParam("id") final String id) {
        applicationService.delete(id);
    }
}
