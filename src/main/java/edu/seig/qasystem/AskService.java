package edu.seig.qasystem;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AskService {
    List<Problem> problems = new ArrayList<Problem>();

    public void add(String question) {
        problems.add(new Problem(question, null));
    }

    public Problem search(int id) {
        for (int k=0; k < problems.size(); k++) {
            if (problems.get(k).id == id) {
                return problems.get(k);
            }
        }
        return null;
    }

    public void answer(int q, String ans) {
        for(int k = 0; k < problems.size(); k++) {
            if (problems.get(k).id == q) {
                problems.get(k).answer = ans;
                break;
            }
        }
    }

    public void deleteProblem(int id) {
        for (int k=0; k< problems.size(); k++) {
            if (problems.get(k).id == id) {
                problems.remove(k);
                break;
            }
        }
    }
}
