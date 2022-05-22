package com.bkash.dynamoenhancedpoc.controller;

import com.bkash.dynamoenhancedpoc.dao.Student;
import com.bkash.dynamoenhancedpoc.repository.dynamo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;


    @GetMapping("/students")
    public Flux<Student> getStudentList() {
        return studentRepository.getAllStudents();
    }

    @PostMapping("/students")
    public Mono<Void> saveStudent(@RequestBody Student student){
        return studentRepository.saveStudent(student);
    }

    
}
