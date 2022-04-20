package com.letscode.harryPotterProject.response;

import com.letscode.harryPotterProject.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StudentResponse {
    private UUID id;
    private String name;
    private Integer year;
    private String houseKey;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.year = student.getYear();
        this.houseKey = student.getHouseKey();
    }

    public StudentResponse(UUID randomUUID, String name, Integer year) {
    }
}
