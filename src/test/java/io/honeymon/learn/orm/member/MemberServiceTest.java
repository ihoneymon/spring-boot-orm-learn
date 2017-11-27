package io.honeymon.learn.orm.member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService service;
    
    
    
    @Test
    public void testMemberSave() throws Exception {
        // given
        Member member = new Member();

        // when
        Member savedMember = service.save(member);

        // then
        assertThat(savedMember, is(member));
    }
    
    
    @Test
    public void testDelete() throws Exception {
        // given
        Member savedMember = service.save(new Member());

        // when
        service.delete(savedMember);

        // then
        Member findOne = service.findById(savedMember.getId());
        assertThat(findOne, is(nullValue()));
    }

}
