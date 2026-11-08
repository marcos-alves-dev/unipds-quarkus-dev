package unipds.java.elite.v2.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import unipds.java.elite.v2.application.port.in.FetchMoviesUseCase;
import unipds.java.elite.v2.application.port.out.MovieGateway;
import unipds.java.elite.v2.domain.model.Movie;

import java.util.List;

@ApplicationScoped
public class FetchMoviesInteractor implements FetchMoviesUseCase {

    private final MovieGateway movieGateway;

    public FetchMoviesInteractor(MovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    @Override
    public List<Movie> execute() {
        return movieGateway.fetchMovies();
    }
}
