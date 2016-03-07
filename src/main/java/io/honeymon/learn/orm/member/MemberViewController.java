package io.honeymon.learn.orm.member;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 회원 생성 화면
     * 
     * @param memberForm
     * @return
     */
    @RequestMapping(value = "create", method = GET)
    public String viewCreate(MemberForm memberForm) {
        return "members/detail";
    }

    @RequestMapping(method = POST)
    public String createMember(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // TODO 에러발생한 것에 대한 처리
            return "members/detail";
        }
        memberService.save(memberForm.createEntity());
        return "redirect:/members";
    }

    @RequestMapping(value = "/{member}", method = GET)
    public String viewModifyMember(@PathVariable Member member, MemberForm memberForm, Model model) {
        model.addAttribute("member", member);
        memberForm.setName(member.getName());
        memberForm.setEmail(member.getEmail());
        return "members/detail";
    }

    @RequestMapping(value = "/{member}", method = PUT)
    public String modifyMember(@PathVariable Member member, @Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/detail";
        }

        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        memberService.save(member);

        return "redirect:/members";
    }
}
