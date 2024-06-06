package resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.CarsService;

@Path("/cars")
public class CarsResource {
    @Inject
    private CarsService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFull(){
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id){
        return Response.ok(service.findById(id)).build();
    }
}
