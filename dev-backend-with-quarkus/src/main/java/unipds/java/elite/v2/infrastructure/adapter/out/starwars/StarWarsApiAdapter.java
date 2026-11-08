package unipds.java.elite.v2.infrastructure.adapter.out.starwars;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import unipds.java.elite.v2.application.port.out.MovieGateway;
import unipds.java.elite.v2.domain.model.Movie;
import unipds.java.elite.v2.infrastructure.adapter.out.starwars.dto.StarWarsFilmResponse;

import java.util.List;

@ApplicationScoped
public class StarWarsApiAdapter implements MovieGateway {


    private final StarWarsRestClient starWarsRestClient;

    public StarWarsApiAdapter(@RestClient StarWarsRestClient starWarsRestClient) {
        this.starWarsRestClient = starWarsRestClient;
    }

    @Override
    public List<Movie> fetchMovies() {
       return toDomain(this.starWarsRestClient.fetchMovies());
    }

    private List<Movie> toDomain(List<StarWarsFilmResponse> starWarsFilmResponses) {
        return starWarsFilmResponses.stream()
                .map(response -> new Movie(
                        response.title(),
                        response.episode_id(),
                        response.opening_crawl(),
                        response.director(),
                        response.producer(),
                        response.release_date(),
                        response.characters(),
                        response.planets(),
                        response.starships(),
                        response.vehicles(),
                        response.species(),
                        response.created(),
                        response.edited(),
                        response.url()
                ))
                .toList();

    }
}
