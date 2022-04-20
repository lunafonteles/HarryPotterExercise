package com.letscode.harryPotterProject.service;

import com.letscode.harryPotterProject.models.Student;
import com.letscode.harryPotterProject.persistence.StudentRepository;
import com.letscode.harryPotterProject.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student create(StudentRequest studentRequest) {
        Student student = new Student(
                UUID.randomUUID(),
                studentRequest.getName(),
                studentRequest.getYear()
        );

        studentRepository.save(student);
        return student;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
