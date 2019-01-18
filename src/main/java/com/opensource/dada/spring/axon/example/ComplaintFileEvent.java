package com.opensource.dada.spring.axon.example;

import lombok.Value;

@Value
public class ComplaintFileEvent {
    String id;
    String company;
    String description;
}
