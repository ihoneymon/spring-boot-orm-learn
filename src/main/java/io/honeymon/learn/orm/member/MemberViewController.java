package io.honeymon.learn.orm.member;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberViewController {
    @Autowired
    private MemberService memberService;

    @ModelAttribute("memberForm")
    public MemberForm memberForm() {
        return new MemberForm();
    }

    @RequestMapping(method = GET)
    public String viewMain(MemberCondition condition, Pageable pageable, Model model) {
        model.addAttribute("page", memberService.search(condition, pageable));        
        return "members/main";
    }

    /**
     * 회원 생성
     * @param memberForm
     * @return
     */
    @RequestMapping(value = "create", method = GET)
    public String viewCreate(MemberForm memberForm) {
        return "members/create";
    }
}
