package br.mandacaru.class04.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;

    private final List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        return "index"; // view
    }

    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("message", name);
        return "index"; // view
    }
}
