package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Dto.MemberDto;
import com.kilic.hrproject.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;


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
