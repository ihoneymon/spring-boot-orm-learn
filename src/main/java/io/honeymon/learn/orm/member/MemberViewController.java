package io.honeymon.learn.orm.member;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberViewController {

    @RequestMapping(method = GET)
    public String viewMain(Model model) {
        model.addAttribute("members", "not implements");
        return "members/main";
    }
}
