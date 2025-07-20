package fr.zelytra;

import io.quarkus.logging.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class PublicRest {

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public Response publicPing() {
        Log.info("[GET] public/ping");
        return Response.ok("Pong!").build();
    }
}
