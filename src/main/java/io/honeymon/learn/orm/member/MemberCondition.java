package io.honeymon.learn.orm.member;

import java.io.Serializable;

import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class MemberCondition implements Serializable {
    private static final long serialVersionUID = -5017020793542280960L;

    private String keyword;

    public boolean hasKeyword() {
        return StringUtils.hasText(keyword);
    }

}
