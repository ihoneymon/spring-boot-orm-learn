package io.honeymon.learn.orm.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = 8104253266176800572L;

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String name;

    @Getter
    @CreatedDate
    private Date createdDate;

    @Getter
    @LastModifiedDate
    private Date lastModifiedDate;

    protected Member() {
    }

    public Member(String name, String email) {
        Assert.hasText(name);
        Assert.hasText(email);

        this.name = name;
        this.email = email;
    }
}
