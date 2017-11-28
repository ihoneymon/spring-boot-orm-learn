package io.honeymon.learn.orm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.honeymon.learn.orm.domain.Member;
import io.honeymon.learn.orm.service.MemberService;

@RequestMapping("members")
@RestController
public class MemberRestController {

    @Autowired
    private MemberService memberService;
    
    @DeleteMapping("/{member}")
    public ResponseEntity deleteMember(@PathVariable Member member) {
        memberService.delete(member);
        return ResponseEntity.ok().build();
    }
}
