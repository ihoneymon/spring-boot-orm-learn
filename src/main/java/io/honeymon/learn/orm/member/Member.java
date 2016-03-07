package io.honeymon.learn.orm.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@EntityListeners(MemberEntityListener.class)
public class Member implements Serializable {
    private static final long serialVersionUID = 8104253266176800572L;

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    private Date createdDate;

    @Getter
    @Setter(AccessLevel.PROTECTED)
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
