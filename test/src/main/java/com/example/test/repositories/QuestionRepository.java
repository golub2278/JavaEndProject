package com.example.test.repositories;

import com.example.test.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface QuestionRepository extends JpaRepository<Question, Long> {
    }

