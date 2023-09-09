package edu.seig.qasystem;

import lombok.Data;

@Data
public class Problem {
    static int initid = 1;
    String question;
    String answer;
    int id;

    public Problem (String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.id = initid++;
    }
}
