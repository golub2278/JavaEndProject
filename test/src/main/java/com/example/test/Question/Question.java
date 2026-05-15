package com.example.test.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Entity
    @Table(name = "quiz_questions")
    @Data
    public class Question {
        @Id
        private Long id;

        private String questionText;


        @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
        private List<Answer> answers;
}
