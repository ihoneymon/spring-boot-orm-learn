package io.honeymon.learn.orm.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.BooleanBuilder;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository repository;

    @Transactional
    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Transactional
    @Override
    public void delete(Member member) {
        repository.delete(member);
    }

    @Override
    public Member findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Member> search(MemberCondition condition, Pageable pageable) {
        QMember member = QMember.member;
        BooleanBuilder predicate = new BooleanBuilder();

        if (condition.hasKeyword()) {
            String likeExpressionKeyword = new StringBuilder().append("%").append(condition.getKeyword()).append("%")
                    .toString();
            predicate.and(member.name.like(likeExpressionKeyword).or(member.email.like(likeExpressionKeyword)));
        }

        return repository.findAll(predicate, pageable);
    }

}
