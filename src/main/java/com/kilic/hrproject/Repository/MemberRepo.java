package com.kilic.hrproject.Repository;

import com.kilic.hrproject.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member,Long> {

    Optional<Member> findByEmail(String email);
}
