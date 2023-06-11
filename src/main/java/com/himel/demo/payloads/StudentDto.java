package com.himel.demo.payloads;

import com.himel.demo.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private Integer roll;
    List<SubjectDto> subjectDtoList;

}

