package com.letscode.harryPotterProject.service;

import com.letscode.harryPotterProject.clients.GetHouseClient;
import com.letscode.harryPotterProject.clients.HouseKeyInfo;
import com.letscode.harryPotterProject.models.Student;
import com.letscode.harryPotterProject.persistence.StudentRepository;
import com.letscode.harryPotterProject.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final GetHouseClient getHouseClient;

    public Student create(StudentRequest studentRequest) {
        Student student = new Student();
            student.setName(studentRequest.getName());
            student.setYear(studentRequest.getYear());

            HouseKeyInfo key = getHouseClient.execute();
            student.setHouseKey(key.getKey());

            studentRepository.save(student);
            return student;
        }

    public Optional<Student> findById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        HouseKeyInfo houseName = getHouseClient.retrieve(student.get().getHouseKey());
        student.get().setHouseName(houseName.getName());
        return student;
    }
}
