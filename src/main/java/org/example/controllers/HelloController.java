package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.difexample.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public record HelloController(ClientComponent clientComponent) {

    @GetMapping("/")
    public String sayHello() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}