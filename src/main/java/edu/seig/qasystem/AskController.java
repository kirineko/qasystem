package edu.seig.qasystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AskController {
    AskService askService;

    public AskController(AskService askService) {
        this.askService = askService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model m) {
        m.addAttribute("message", askService.problems);
        return "askpage";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String askProcess(Model m, @RequestParam("ask") String question) {
        askService.add(question);
        m.addAttribute("message", askService.problems);
        return "askpage";
    }

    @RequestMapping(value = "/youranswer/{id}", method = RequestMethod.GET)
    public String ans(Model m, @PathVariable("id") int id) {
        Problem yourProblem = askService.search(id);
        m.addAttribute("problem", yourProblem);
        return "answerpage";
    }

    @RequestMapping(value = "/processanswer/{id}", method = RequestMethod.POST)
    public String ansProcess(Model m, @PathVariable("id") int id,
                             @RequestParam("myans") String answer) {
        askService.answer(id, answer);
        m.addAttribute("message", askService.problems);
        return "askpage";
    }

    @RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
    public String deleteById(@RequestParam("id") int id) {
        askService.deleteProblem(id);
        return "redirect:/";
    }

}
