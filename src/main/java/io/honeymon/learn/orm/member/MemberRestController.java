package io.honeymon.learn.orm.member;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("members")
@RestController
public class MemberRestController {

    @Autowired
    private MemberService memberService;
    
    @RequestMapping(value = "/{member}", method = DELETE)
    public ResponseEntity deleteMember(@PathVariable Member member) {
        memberService.delete(member);
        return ResponseEntity.ok().build();
    }
}
