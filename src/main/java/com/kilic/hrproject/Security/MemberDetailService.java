package com.kilic.hrproject.Security;

import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MemberRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> member=repo.findByEmail(email);
        return member.map(MemberDetails::new).orElseThrow(() -> new UsernameNotFoundException("Member not found!"));
    }
}
