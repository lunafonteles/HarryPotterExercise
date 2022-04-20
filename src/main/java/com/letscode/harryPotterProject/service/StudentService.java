package com.letscode.harryPotterProject.service;

import com.letscode.harryPotterProject.clients.GetHouseClient;
import com.letscode.harryPotterProject.clients.HouseKeyInfo;
import com.letscode.harryPotterProject.models.Student;
import com.letscode.harryPotterProject.persistence.StudentRepository;
import com.letscode.harryPotterProject.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GetHouseClient getHouseClient;
    private final HouseKeyInfo houseKeyInfo;

    public Student create(StudentRequest studentRequest) {
        Student student = new Student();
            student.setName(studentRequest.getName());
            student.setYear(studentRequest.getYear());
            student.setHouseKey(houseKeyInfo.getKey());

/*        if(student.getHouseKey().equals(0)) {
            student.setHouseKey(houseKeyInfo.getKey());

            studentRepository.save(student);
            return student;
        }
        return null;*/
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
