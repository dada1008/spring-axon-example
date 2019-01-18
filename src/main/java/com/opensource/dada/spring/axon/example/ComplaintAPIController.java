package com.opensource.dada.spring.axon.example;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

//@RequestMapping("/complaints")
@RestController
public class ComplaintAPIController {

    private final ComplaintQueryObjectRepository repository;
    private CommandGateway commandGateway;


    public ComplaintAPIController(ComplaintQueryObjectRepository repository, CommandGateway commandGateway) {
        this.repository = repository;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public List<ComplaintQueryObject> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ComplaintQueryObject find(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public CompletableFuture<String> fileComplaint(@RequestBody Map<String, String> request) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(new FileComplaintCommand(id, request.get("company"), request.get("description")));
    }
}
