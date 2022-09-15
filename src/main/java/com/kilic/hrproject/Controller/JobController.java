package com.kilic.hrproject.Controller;

import com.kilic.hrproject.Model.JobAdvertisement;
import com.kilic.hrproject.Service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final JobService service;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("job",new JobAdvertisement());
        return "admin-page";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("job")JobAdvertisement advertisement){
        service.save(advertisement);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteJob(@RequestParam("id") long id){
        service.deleteById(id);
        return "redirect:/";
    }



    @GetMapping("/")
    public String listJob(Model model){

        model.addAttribute("jobs",service.getAll());
        return "joblist";
    }


}
