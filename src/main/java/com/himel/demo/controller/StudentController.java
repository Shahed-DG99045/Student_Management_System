package com.himel.demo.controller;

import com.himel.demo.payloads.StudentDto;
import com.himel.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto createStudent = this.studentService.createStudent(studentDto);
        return new ResponseEntity<StudentDto>(createStudent, HttpStatus.CREATED);
    }
}

