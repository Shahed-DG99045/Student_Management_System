package com.himel.demo.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SubjectDto {
    private Long id;
    private Long studentId;
    private String sub1;
    private String sub2;
}