package io.honeymon.learn.orm.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @CreatedDate
    private Date createdDate;
    
    @LastModifiedDate
    private Date lastModifiedDate;
}
