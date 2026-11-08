package unipds.java.elite.v2.application.port.out;

import unipds.java.elite.v2.domain.model.Movie;

import java.util.List;

public interface MovieGateway {
    List<Movie> fetchMovies();
}
