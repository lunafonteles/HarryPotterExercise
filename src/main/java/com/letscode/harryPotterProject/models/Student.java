package com.letscode.harryPotterProject.models;

import com.letscode.harryPotterProject.request.StudentRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private Integer year;
    @Column(name = "houseKey")
    private String houseKey;
    @Column(name = "houseName")
    private String houseName;

    public Student(StudentRequest studentRequest) {
        this.name = studentRequest.getName();
        this.year = studentRequest.getYear();
    }

    public Student(String name, Integer year) {
    }
}
