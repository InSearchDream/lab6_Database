package ru.rsatu.resource;

import ru.rsatu.pojo.Trainer;
import ru.rsatu.service.TrainerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trainer-resource")
public class TrainerResource {

    @Inject
    TrainerService trainerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainerById")
    public Response getTrainerById(@QueryParam("id") Long id){
        return Response.ok(trainerService.getTrainerById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertTrainer")
    public Response insertTrainer(Trainer trainer){
        return Response.ok(trainerService.insertTrainer(trainer)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateTrainer")
    public Response updateTrainer(Trainer trainer){
        return Response.ok(trainerService.updateTrainer(trainer)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteTrainer")
    public Response deleteTrainer(Trainer trainer){
        trainerService.deleteTrainer(trainer);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainers")
    public Response getTrainers(){
        return Response.ok(trainerService.getTrainers()).build();
    }

}
