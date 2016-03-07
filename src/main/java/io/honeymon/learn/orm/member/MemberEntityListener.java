package io.honeymon.learn.orm.member;

import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class MemberEntityListener {

    @PostPersist
    public void postPersist(Member member) {
        member.setCreatedDate(new Date());
    }
    
    @PostUpdate
    public void postUpdate(Member member) {
        member.setLastModifiedDate(new Date());
    }
}
