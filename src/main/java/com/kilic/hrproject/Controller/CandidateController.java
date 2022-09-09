package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    private static Logger logger=Logger.getLogger(CandidateController.class.getName());

    @GetMapping("/job")
    public String applicationPage(Model model){
        model.addAttribute("candidate",new Candidate());
        return "job-application";
    }


    @PostMapping("/apply")
    public String save(@ModelAttribute("candidate") Candidate candidate){
        logger.info(" "+ LocalDate.now());
        candidateService.save(candidate);
        return "job-application";
    }
}
