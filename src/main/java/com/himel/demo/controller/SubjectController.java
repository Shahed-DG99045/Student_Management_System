package com.himel.demo.controller;

import com.himel.demo.payloads.SubjectDto;
import com.himel.demo.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/")
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto createSubject = this.subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(createSubject, HttpStatus.CREATED);
    }
}
