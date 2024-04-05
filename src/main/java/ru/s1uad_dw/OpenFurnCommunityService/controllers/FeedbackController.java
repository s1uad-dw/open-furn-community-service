package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.services.FeedbackService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/community/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateFeedbackDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_project_id")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewFeedbackDto> findByProjectId(@RequestParam UUID projectId){
        return service.findByProjectId(projectId);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewFeedbackDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }

}
