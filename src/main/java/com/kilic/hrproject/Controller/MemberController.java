package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Dto.MemberDto;
import com.kilic.hrproject.Dto.ProfileDto;
import com.kilic.hrproject.Dto.SavedJobListDto;
import com.kilic.hrproject.Model.Image;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Model.Profile;
import com.kilic.hrproject.Service.JobService;
import com.kilic.hrproject.Service.MemberService;
import com.kilic.hrproject.Service.ProfileService;
import com.kilic.hrproject.Service.StorageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final JobService jobService;
    private final ProfileService profileService;
    private final StorageService storageService;
    private final ModelMapper mapper;


    @GetMapping("/login")
    public String login(){
        return "login-page";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        ProfileDto profileDto=mapper.map(service.getByEmail(principal.getName()),ProfileDto.class);
        System.out.println(profileDto.getProfile().getImage().getPath());
        model.addAttribute("profil",profileDto);
        return "profile";
    }

    @GetMapping("/register")
    public String signUp(Model model){
        model.addAttribute("register",new MemberDto());
        return "sign-up";
    }

    @GetMapping("/enrollment")
    public String saveJob(@RequestParam("name") String jobName, Principal principal){
        Profile profile=service.getByEmail(principal.getName()).getProfile();
        profile.getSavedJobs().add(jobService.getByName(jobName));
        profileService.updateProfile(profile);
        return "redirect:/";
    }

    @GetMapping("/saved")
    public String savedJob(Model model,Principal principal){
        SavedJobListDto jobListDto=mapper.map(service.getByEmail(principal.getName()).getProfile(),SavedJobListDto.class);
        model.addAttribute("jobList",jobListDto);
        return "saved-job";
    }

    @PostMapping("/register/save")
    public String saveMember(@ModelAttribute("register") MemberDto memberDto){
        service.save(memberDto);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("profile")ProfileDto profileDto,Principal principal){
        if(!profileDto.getFile().isEmpty()) {
            storageService.store(profileDto.getFile());
            String[] link = storageService.load(profileDto.getFile().getOriginalFilename()).toString().replace('\\', '/').split("/");
            profileDto.getProfile().getImage().setPath("/image/" + link[link.length - 1]);
        }
        Profile profile=mapper.map(profileDto.getProfile(),Profile.class);
        Member member= service.getByEmail(principal.getName());
        profile.setId(member.getProfile().getId());
        profile.setMember(member);
        profileService.updateProfile(profile);
        return "redirect:/profile";
    }
}
