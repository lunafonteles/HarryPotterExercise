package com.letscode.harryPotterProject.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Student {
    private UUID id;
    private String name;
    private Integer year;
    private String houseKey;

    public Student(UUID id, String name, Integer year) {
    }
}
