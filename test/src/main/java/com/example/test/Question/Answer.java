package com.example.test.Question;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
    @Table(name = "quiz_answers")
    @Data
    public class Answer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String answerText;
        private int points;

        @ManyToOne
        @JoinColumn(name = "question_id")
        private Question question;
    }


