package unipds.java.elite.v1.eldermoraes.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarWarsService {

    String MSG_ERROR = "Fallback ";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films")
    @Timeout(value = 3000L)
    @Fallback(fallbackMethod = "fetchMoviesFallback")
    @CircuitBreaker(
            requestVolumeThreshold = 2,
            failureRatio = 0.5,
            delay = 5000L,
            successThreshold = 2
    )
    String fetchMovies();

    default String fetchMoviesFallback() {
        return MSG_ERROR;
    }

}
