package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Dto.MemberDto;
import com.kilic.hrproject.Dto.ProfileDto;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final ModelMapper mapper;

    @GetMapping("/login")
    public String login(){
        return "login-page";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        ProfileDto profileDto=mapper.map(service.getByEmail(principal.getName()),ProfileDto.class);
        model.addAttribute("profile",profileDto);
        return "profile-page";
    }

    @GetMapping("/register")
    public String signUp(Model model){
        model.addAttribute("register",new MemberDto());
        return "sign-up";
    }

    @PostMapping("/register/save")
    public String saveMember(@ModelAttribute("register") MemberDto memberDto){
        service.save(memberDto);
        return "redirect:/list";
    }
}
