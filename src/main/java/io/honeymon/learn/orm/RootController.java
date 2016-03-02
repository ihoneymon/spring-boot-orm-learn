package io.honeymon.learn.orm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    public String viewIndex(Model model) {
        model.addAttribute("greeting", "Hello, world!");
        return "index";
    }
}
