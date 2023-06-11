package com.himel.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    private String sub1;
    private String sub2;

    public Subject(Long studentId, String sub1, String sub2) {
        this.studentId = studentId;
        this.sub1 = sub1;
        this.sub2 = sub2;
    }
}