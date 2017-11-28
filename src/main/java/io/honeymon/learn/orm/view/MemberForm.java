package io.honeymon.learn.orm.view;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import io.honeymon.learn.orm.domain.Member;
import lombok.Data;

@Data
public class MemberForm implements Serializable {
    private static final long serialVersionUID = 7249135497399309440L;

    @Length(min = 5, max = 30)
    @NotEmpty
    private String name;

    @Length(min = 5, max = 30)
    @NotEmpty
    private String email;

    public Member createEntity() {
        return new Member(name, email);
    }
}
