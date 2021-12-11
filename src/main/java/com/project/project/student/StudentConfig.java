package com.project.project.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student thallys = new Student(
                    1L,
                    "Thallys",
                    "thallys@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student victoria = new Student(
                    "Victoria",
                    "victoria@gmail.com",
                    LocalDate.of(1998, JANUARY, 5)
            );

            repository.saveAll(
                    List.of(thallys, victoria)
            );
        };
    }
}
