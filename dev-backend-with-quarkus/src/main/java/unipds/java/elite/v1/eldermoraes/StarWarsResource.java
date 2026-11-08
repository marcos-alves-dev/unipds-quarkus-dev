package unipds.java.elite.v1.eldermoraes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import unipds.java.elite.v1.eldermoraes.services.StarWarsService;

@Path("/v1/starwars")
public class StarWarsResource {


    @RestClient
    StarWarsService starWarsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("movies")
    public String fetchMovies(){
        return starWarsService.fetchMovies();
    }

}
