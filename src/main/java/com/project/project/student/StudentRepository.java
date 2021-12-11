package com.project.project.student;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {


    Optional<Student> findByEmail(String email);

}

