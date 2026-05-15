package com.example.test;

import java.util.List;

public class QuizLogic {
    public int calculateSum(List<Integer> answers) {
        int total = 0;
        for (int point : answers) {
            total += point;
        }
        return total;
    }
    public String getResult(int score) {
        if (score >= 10 && score <= 18) {
            return "Стальной Табурет";
        } else if (score >= 19 && score <= 27) {
            return "Офисный Работяга";
        } else if (score >= 28 && score <= 36) {
            return "Космический Пуфик";
        } else if (score >= 37 && score <= 45) {
            return "Кресло-Качалка Мудрец";
        } else if (score >= 46 && score <= 50) {
            return "Кибер-Трон 3000";
        } else {
            return "Загадочный стул";
        }
    }

    public String getImagePath(String resultTitle) {
        switch (resultTitle) {
            case "Стальной Табурет": return "taburet.jpg";
            case "Офисный Работяга": return "office.jpg";
            case "Космический Пуфик": return "puf.jpg";
            case "Кресло-Качалка Мудрец": return "kachalka.jpg";
            case "Кибер-Трон 3000": return "cyber.jpg";
            default: return "default.jpg";
        }
    }
}
