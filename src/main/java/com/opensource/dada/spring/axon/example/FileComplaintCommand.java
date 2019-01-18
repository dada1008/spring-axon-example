package com.opensource.dada.spring.axon.example;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class FileComplaintCommand {
    @TargetAggregateIdentifier
    String id;
    private String company;
    private String description;
}
