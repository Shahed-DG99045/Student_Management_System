package com.himel.demo.service;

import com.himel.demo.payloads.SubjectDto;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);
}