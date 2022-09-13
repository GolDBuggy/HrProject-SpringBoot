package com.kilic.hrproject.Service;

import com.kilic.hrproject.Dto.MemberDto;
import com.kilic.hrproject.Model.Image;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Model.Profile;
import com.kilic.hrproject.Repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo repo;
    private final ProfileService profileService;
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
        createProfile(member);
    }


    private void checkPassword(MemberDto memberDto){
        if(!memberDto.getPassword().equals(memberDto.getRePass()))
            throw new RuntimeException("Passwords must be equals!");
    }


    public Member getByEmail(String email){
        return  repo.findByEmail(email).get();
    }


    public void update(Member member) {
        repo.save(member);
    }


    private void createProfile(Member member){
        Image image=new Image();
        Profile profile= Profile.builder().member(member).image(image).build();
        profileService.saveProfile(profile);
    }
}
