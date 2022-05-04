package com.example.demo.controllers;

import com.example.demo.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ActivityViewController {

    private final ActivityService activityService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activity", activityService.getNewActivity());
        return "index";
    }
}
