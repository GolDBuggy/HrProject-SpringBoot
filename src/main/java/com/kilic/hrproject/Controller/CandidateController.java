package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Dto.ApplyDto;
import com.kilic.hrproject.Dto.ReferenceDto;
import com.kilic.hrproject.Model.Candidate;
import com.kilic.hrproject.Model.Member;
import com.kilic.hrproject.Service.CandidateService;
import com.kilic.hrproject.Service.JobService;
import com.kilic.hrproject.Service.MemberService;
import com.kilic.hrproject.Service.StorageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final MemberService memberService;
    private final JobService jobService;
    private final StorageService storageService;
    private final ModelMapper mapper;

    private static Logger logger=Logger.getLogger(CandidateController.class.getName());

    @GetMapping("/job")
    public String applicationPage(@RequestParam("id") long id, Model model,Principal principal){
        model.addAttribute("JobId",id);
        if (!(principal==null)){
            ApplyDto applyDto=mapper.map(memberService.getByEmail(principal.getName()),ApplyDto.class);
            model.addAttribute("candidate",applyDto);
        }
        else
            model.addAttribute("candidate",new ApplyDto());
        return "job-application";
    }




    @GetMapping("/list")
    public String applyList(Model model){
        List<ReferenceDto> referenceDtos=new ArrayList<>();
        candidateService.getAll().stream().forEach(e -> referenceDtos.add(new ReferenceDto(e.getName(),e.getSurname(),
                                                e.getEmail(),e.getJobAdvertisements(),
                MvcUriComponentsBuilder.fromMethodName(CandidateController.class,
                        "serveFile", e.getPath().getPath()).build().toUri().toString())));



        model.addAttribute("liste",referenceDtos);
        return "reference-list";
    }




    @GetMapping("/files/cv")
    public ResponseEntity<Resource> serveFile(String filename) {

        Resource file = storageService.loadPdfAsResource(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @PostMapping("/apply")
    public String save(@ModelAttribute("candidate") ApplyDto candidate){
        if (!candidate.getFile().isEmpty())
           storageService.storePdf(candidate.getFile());

        candidateService.save(candidate);
        return "job-application";
    }
}
