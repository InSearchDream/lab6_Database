package ru.rsatu.resource;

import ru.rsatu.pojo.Group;
import ru.rsatu.service.GroupService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/group-resource")
public class GroupResource {

    @Inject
    GroupService groupService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getGroupById")
    public Response getGroupById(@QueryParam("id") Long id){
        return Response.ok(groupService.getGroupById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertGroup")
    public Response insertGroup(Group group){
        return Response.ok(groupService.insertGroup(group)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateGroup")
    public Response updateChild(Group group){
        return Response.ok(groupService.updateGroup(group)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteGroup")
    public Response deleteGroup(Group group){
        groupService.deleteGroup(group);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getGroups")
    public Response getGroups(){
        return Response.ok(groupService.getGroups()).build();
    }

}
