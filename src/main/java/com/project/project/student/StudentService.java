package com.project.project.student;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return (List<Student>) studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        if (student != null && Objects.equals(student.getEmail(), email)) {
            studentRepository.findByEmail(email)
                    .ifPresent(emailOfStudent -> {
                        throw new IllegalStateException("Email has been taken! ");
                    });
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Non Ecxist!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        if (name == null && email == null){
            throw new IllegalStateException("Invalid Param");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->  new IllegalStateException("Student with id " + studentId + " does not exist."));

        if (!Objects.equals(student.getName(), name) && name != null){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && Objects.equals(student.getEmail(), email)){
            studentRepository.findByEmail(email)
                    .ifPresent( emailOfStudent -> {
                        throw new IllegalStateException("Email has been taken! ");
                    });
            student.setEmail(email);
        }
    }
}
