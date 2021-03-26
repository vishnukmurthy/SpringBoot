package com.example.springboot.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // SELEcT * FROM student WHERE email = email;
    @Query("SELECT s FROM Student s Where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
