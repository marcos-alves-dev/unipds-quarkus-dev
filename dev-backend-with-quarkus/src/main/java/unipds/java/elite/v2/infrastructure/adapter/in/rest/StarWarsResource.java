package unipds.java.elite.v2.infrastructure.adapter.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import unipds.java.elite.v2.application.port.in.FetchMoviesUseCase;
import unipds.java.elite.v2.domain.model.Movie;

import java.util.List;

@Path("/v2/starwars")
public class StarWarsResource {

    private final FetchMoviesUseCase fetchMoviesUseCase;

    @Inject
    public StarWarsResource(FetchMoviesUseCase fetchMoviesUseCase) {
        this.fetchMoviesUseCase = fetchMoviesUseCase;
    }
    @GET
    @Path("/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        return fetchMoviesUseCase.execute();
    }
}
