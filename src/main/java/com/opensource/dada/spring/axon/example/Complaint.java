package com.opensource.dada.spring.axon.example;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Complaint {
    @AggregateIdentifier
    String complaintId;

    public Complaint() {

    }

    @CommandHandler
    public Complaint(FileComplaintCommand command) {
        Assert.hasLength(command.getCompany(), " company must have length; it must not be null or empty");

        apply(new ComplaintFileEvent(command.getId(), command.getCompany(), command.getDescription()));
    }

    @EventSourcingHandler
    public void on(ComplaintFileEvent event) {
        this.complaintId = event.getId();
    }
}
