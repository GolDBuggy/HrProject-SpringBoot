package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Dto.ApplyDto;
import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Service.CandidateService;
import com.kilic.hrproject.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final MemberService memberService;
    private final ModelMapper mapper;

    private static Logger logger=Logger.getLogger(CandidateController.class.getName());

    @GetMapping("/job")
    public String applicationPage(@RequestParam("id") long id, Model model,Principal principal){
        logger.info(id+"  ");
        model.addAttribute("JobId",id);
        if (!principal.getName().isEmpty()){
            ApplyDto applyDto=mapper.map(memberService.getByEmail(principal.getName()),ApplyDto.class);
            model.addAttribute("candidate",applyDto);
        }
        else
            model.addAttribute("candidate",new ApplyDto());
        return "job-application";
    }


    @PostMapping("/apply")
    public String save(@ModelAttribute("candidate") ApplyDto candidate){
        logger.info(" "+ candidate);
        candidateService.save(candidate);
        return "job-application";
    }
}
