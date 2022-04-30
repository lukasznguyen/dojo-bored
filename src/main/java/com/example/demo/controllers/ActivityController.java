package com.example.demo.controllers;

import com.example.demo.models.dtos.ActivityResDTO;
import com.example.demo.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("new")
    public ResponseEntity<ActivityResDTO> getNewActivity() {
        return ResponseEntity.ok(activityService.getNewActivity());
    }
}
