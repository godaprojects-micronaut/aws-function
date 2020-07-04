package io.goda.aws.function.v4.controller;

import io.goda.aws.service.HelloService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/")
public class HelloController {
    @Inject
    private HelloService helloService;

    @Get("/hello/{name}")
    public String sayHello(String name){
        return String.format("Hello %s - (V4 - Using API gateway concepts and controller)", name);
    }
}
