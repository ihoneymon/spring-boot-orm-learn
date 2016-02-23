package io.honeymon.learn.orm.member;

/**
 * {@link Member} 에 대한 서비스를 관리하는 인터페이스
 * 
 * @author jiheon
 *
 */
public interface MemberService {

    /**
     * {@link Member} 를 생성하거나 갱신처리
     * 
     * @param member
     * @return
     */
    Member save(Member member);

    /**
     * Delete {@link Member}
     * 
     * @param member
     */
    void delete(Member member);

    /**
     * Find {@link Member} by {@link Member#getId()}
     * 
     * @param id
     * @return
     */
    Member findById(Long id);

}
