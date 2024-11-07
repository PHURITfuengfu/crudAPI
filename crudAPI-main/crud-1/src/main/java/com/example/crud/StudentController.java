package com.example.crud.controller;

import com.example.crud.dto.StudentDTO;
import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    // Method to get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Method to add a new student
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
