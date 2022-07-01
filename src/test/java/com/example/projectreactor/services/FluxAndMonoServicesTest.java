package com.example.projectreactor.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Apple", "Mongo", "Orange")
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoServices.fruitMono();
        StepVerifier.create(fruitMono)
                .expectNext("Apple")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitsFluxMap = fluxAndMonoServices.fruitsFluxMap();

        StepVerifier.create(fruitsFluxMap)
                .expectNext("APPLE", "MONGO", "ORANGE")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFluxFilter = fluxAndMonoServices.fruitsFluxFilter(5 );

        StepVerifier.create(fruitsFluxFilter)
                .expectNext("Orange")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        var fruitsFluxFilterMap = fluxAndMonoServices.fruitsFluxFilterMap(5);

        StepVerifier.create(fruitsFluxFilterMap)
                .expectNext("ORANGE")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitsFluxFlatMap = fluxAndMonoServices.fruitsFluxFlatMap();

        StepVerifier.create(fruitsFluxFlatMap)
                .expectNextCount(16)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        var fruitsFluxFlatMap = fluxAndMonoServices.fruitsFluxFlatMapAsync();

        StepVerifier.create(fruitsFluxFlatMap)
                .expectNextCount(16)
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMap() {
        var fruitMonoFlatMap = fluxAndMonoServices.fruitMonoFlatMap();

        StepVerifier.create(fruitMonoFlatMap)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatMap() {
        var fruitsFluxConcatMap = fluxAndMonoServices.fruitsFluxConcatMap();

        StepVerifier.create(fruitsFluxConcatMap )
                .expectNextCount(16)
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMapMany() {
        var fruitMonoFlatMapMany = fluxAndMonoServices.fruitMonoFlatMapMany();

        StepVerifier.create(fruitMonoFlatMapMany)
                .expectNextCount(5)
                .verifyComplete();

    }

    @Test
    void fruitsFluxTransform() {
        var fruitsFluxTransform = fluxAndMonoServices.fruitsFluxTransform(5);

        StepVerifier.create(fruitsFluxTransform)
                .expectNext("Orange")
                .verifyComplete();
    }
}