package ru.rsatu.resource;

import ru.rsatu.pojo.Child;
import ru.rsatu.service.ChildService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/child-resource")
public class ChildResource {

    @Inject
    ChildService childService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getChildById")
    public Response getChildById(@QueryParam("id") Long id){
        return Response.ok(childService.getChildById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertChild")
    public Response insertChild(Child child){
        return Response.ok(childService.insertChild(child)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateChild")
    public Response updateChild(Child child){
        return Response.ok(childService.updateChild(child)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteChild")
    public Response deleteChild(Child child){
        childService.deleteChild(child);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getChilds")
    public Response getChilds(){
        return Response.ok(childService.getChilds()).build();
    }

}
