package io.honeymon.learn.orm.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
