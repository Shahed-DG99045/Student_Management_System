package com.himel.demo.service.Impl;

import com.himel.demo.entity.Student;
import com.himel.demo.entity.Subject;
import com.himel.demo.payloads.StudentDto;
import com.himel.demo.payloads.SubjectDto;
import com.himel.demo.repositories.StudentRepo;
import com.himel.demo.repositories.SubjectRepo;
import com.himel.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final SubjectServiceImpl subjectService;

    public StudentServiceImpl(StudentRepo studentRepo,
                              SubjectRepo subjectRepo,
                              SubjectServiceImpl subjectService) {
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.subjectService = subjectService;
    }
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student stu = this.dtoToStudent(studentDto);
        Student saveStu = this.studentRepo.save(stu);
        List<Subject> subjectsList = new ArrayList<>();
        if(Objects.nonNull(studentDto.getSubjectDtoList())){
            for (SubjectDto subjectDto : studentDto.getSubjectDtoList()) {
                Subject subject = subjectService.dtoToSubject(subjectDto, saveStu.getId());
                subjectsList.add(subject); // add single student id's difference sub according to entity
            }
            List<Subject> subjectSavedList = subjectRepo.saveAll(subjectsList); //save different student subject entity as subjectSavedList
            return this.studentToDto(saveStu, subjectSavedList);
        }

        return this.studentToDto(saveStu, null);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Long studentId) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return null;
    }

    public Student dtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setRoll(studentDto.getRoll());
        return student;
    }
    public StudentDto studentToDto(Student student, List<Subject> subjectList) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setRoll(student.getRoll());
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        if(subjectList!=null){
            subjectList.forEach(subject -> {
                subjectDtoList.add(subjectService.subjectToDto(subject, student.getId()));
            });
        }

        studentDto.setSubjectDtoList(subjectDtoList);
        return studentDto;
    }
}
