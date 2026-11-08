package unipds.java.elite.v2.application.port.in;

import unipds.java.elite.v2.domain.model.Movie;

import java.util.List;

public interface FetchMoviesUseCase {
    List<Movie> execute();
}
