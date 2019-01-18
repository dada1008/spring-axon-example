package com.opensource.dada.spring.axon.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ComplaintQueryObject {
    @Id
    private String complaintId;
    private String company;
    private String description;
}
