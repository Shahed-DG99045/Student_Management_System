package com.himel.demo.service;

import com.himel.demo.payloads.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto,Long studentId);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();

}
