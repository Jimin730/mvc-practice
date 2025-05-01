package com.spring.boardproject.member.repository;

import com.spring.boardproject.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
    boolean existsByLoginId(String loginId);
    boolean existsByNickName(String nickName);
}
