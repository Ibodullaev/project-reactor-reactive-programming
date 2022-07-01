package com.example.projectreactor.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

public class FluxAndMonoServices {
     public Flux<String> fruitsFlux(){
         return Flux.fromIterable(List.of("Apple", "Mongo", "Orange")).log();
     }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitsFluxFilter(int x){
         return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                 .filter(s -> s.length() > x)
                 .log();
    }

    public Flux<String> fruitsFluxFilterMap(int x){
         return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                 .filter(s -> s.length() > x)
                 .map(String::toUpperCase)
                 .log();
    }

    public Flux<String> fruitsFluxFlatMap(){
         return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                 .flatMap(s -> Flux.just(s.split("")))
                 .log();
    }

    public Flux<String> fruitsFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                .flatMap(s -> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .log();
    }

    public Flux<String> fruitsFluxConcatMap(){
         return Flux.fromIterable(List.of("Apple", "Mongo", "Orange"))
                 .concatMap(s -> Flux.just(s.split("")))
                 .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                 .log();
    }

    public Flux<String> fruitsFluxTransform(int number){
         Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > number);
         return Flux.fromIterable(List.of("Mango", "Apple", "Orange"))
                 .transform(filterData)
                 .log();
                //.filter(s -> s.length() > number);
    }

    public Mono<String> fruitMono(){
         return Mono.just("Apple").log();
     }

    public Mono<List<String>> fruitMonoFlatMap(){
         return Mono.just("Mango")
                 .flatMap(s -> Mono.just(List.of(s.split(""))))
                 .log();
    }

    public Flux<String> fruitMonoFlatMapMany(){
        return Mono.just("Mango")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

     public static void main(String[] args){
         FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

         fluxAndMonoServices.fruitsFlux().subscribe(
                 s -> {
                     System.out.println("Flux = " + s);
                 }
         );

         fluxAndMonoServices.fruitMono().subscribe(
                 s -> {
                     System.out.println("Mono = " + s);
                 }
         );

     }
}
