package com.kilic.hrproject.Service;

import com.kilic.hrproject.Dto.MemberDto;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo repo;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT="ROLE_USER";

    public void save(MemberDto memberDto){
        checkPassword(memberDto);
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));
        Member member=mapper.map(memberDto,Member.class);
        member.setActive(true);
        member.setRoles(DEFAULT);
        repo.save(member);
    }


    private void checkPassword(MemberDto memberDto){
        if(!memberDto.getPassword().equals(memberDto.getRePass()))
            throw new RuntimeException("Passwords must be equals!");
    }

}
