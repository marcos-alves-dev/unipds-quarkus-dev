package unipds.java.elite.v2.infrastructure.adapter.out.starwars;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import unipds.java.elite.v2.infrastructure.adapter.out.starwars.dto.StarWarsFilmResponse;

import java.util.List;

@RegisterRestClient(configKey = "starwars-api")
@Path("/films")
public interface StarWarsRestClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<StarWarsFilmResponse> fetchMovies();

}
