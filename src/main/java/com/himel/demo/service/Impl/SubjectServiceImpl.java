package com.himel.demo.service.Impl;

import com.himel.demo.entity.Subject;
import com.himel.demo.payloads.SubjectDto;
import com.himel.demo.repositories.SubjectRepo;
import com.himel.demo.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepo subjectRepo;
    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject sub = this.dtoToSubject(subjectDto, null);
        Subject addSub = this.subjectRepo.save(sub);
        return this.subjectToDto(addSub, null);
    }
    public Subject dtoToSubject(SubjectDto subjectDto, Long studentId) {
        Subject studentSubject = new Subject();
        studentSubject.setId(subjectDto.getId());
        studentSubject.setSub1(subjectDto.getSub1());
        studentSubject.setSub2(subjectDto.getSub2());
        studentSubject.setStudentId(studentId);
        return studentSubject;
    }

    public SubjectDto subjectToDto(Subject subject, Long studentId) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setSub1(subject.getSub1());
        subjectDto.setSub2(subject.getSub2());
        subjectDto.setStudentId(studentId);
        return subjectDto;
    }
}
