package com.himel.demo.repositories;

import com.himel.demo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
}
