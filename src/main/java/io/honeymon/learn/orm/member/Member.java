package io.honeymon.learn.orm.member;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
