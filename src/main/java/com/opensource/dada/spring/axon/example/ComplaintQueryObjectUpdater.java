package com.opensource.dada.spring.axon.example;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ComplaintQueryObjectUpdater {
    private final ComplaintQueryObjectRepository repository;

    public ComplaintQueryObjectUpdater(ComplaintQueryObjectRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ComplaintFileEvent event) {
        repository.save(new ComplaintQueryObject(event.getId(), event.getCompany(), event.getDescription()));
    }
}
