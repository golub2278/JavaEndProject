package com.example.test;


import com.example.test.Question.Question;
import com.example.test.repositories.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final QuestionRepository questionRepository;
    private final QuizLogic quizLogic;


    public QuizController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.quizLogic = new QuizLogic();
    }
    @GetMapping
    public String showTest(Model model){
        List<Question> questions=questionRepository.findAll();
        model.addAttribute("questions", questions);
        return "index";//название файла html
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam("scores") List<Integer> scores, Model model) {

        int total = quizLogic.calculateSum(scores);
        String title = quizLogic.getResult(total);
        String image = quizLogic.getImagePath(title);
        model.addAttribute("imagePath", "/images/" + image); // Передаем путь в HTML

        // Передаем результат в HTML
        model.addAttribute("score", total);
        model.addAttribute("title", title);

        return "result"; // Откроет result.html


    }

}
