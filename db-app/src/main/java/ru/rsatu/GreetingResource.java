package ru.rsatu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//mvn clean quarkus:dev
//http://localhost:8080/q/swagger-ui/
@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/helloRSATU")
    public String helloRSATU() {
        return "Hello helloRSATU";
    }
}