package com.example.demo.services;

import com.example.demo.models.Activity;
import com.example.demo.models.dtos.ActivityExternalApiResDTO;
import com.example.demo.models.dtos.ActivityResDTO;
import com.example.demo.repositories.ActivityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityService {

    @Value("${bored.api.url}")
    private String EXTERNAL_URL;
    private final RestTemplate restTemplate;
    private final ActivityRepo activityRepo;

    public ActivityResDTO getNewActivity() {
        ActivityExternalApiResDTO activity;
        do {
            activity = restTemplate.getForObject(EXTERNAL_URL, ActivityExternalApiResDTO.class);
        } while (activityRepo.findById(activity.getKey()).isPresent());

        activityRepo.save(
                Activity.builder()
                        .id(activity.getKey())
                        .name(activity.getActivity())
                        .build());

        return ActivityResDTO.builder()
                .activity(activity.getActivity())
                .build();
    }
}
