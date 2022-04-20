package com.letscode.harryPotterProject.controller;

import com.letscode.harryPotterProject.models.Student;
import com.letscode.harryPotterProject.request.StudentRequest;
import com.letscode.harryPotterProject.response.StudentResponse;
import com.letscode.harryPotterProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.create(studentRequest);
        return new StudentResponse(student);
    }

    @GetMapping
    public List<StudentResponse> getStudents() {
        List<Student> students =studentService.getAll();
        return students.stream().map(StudentResponse::new).collect(Collectors.toList());
    }
}

