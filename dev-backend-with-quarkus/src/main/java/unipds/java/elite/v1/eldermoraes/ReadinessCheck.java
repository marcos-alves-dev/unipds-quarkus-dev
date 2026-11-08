package unipds.java.elite.v1.eldermoraes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import unipds.java.elite.v1.eldermoraes.services.StarWarsService;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {
        if (starWarsService.fetchMovies().contains(StarWarsService.MSG_ERROR) ) {
            return HealthCheckResponse.down("ERROR");
        }

        return HealthCheckResponse.up("OK");
    }
}