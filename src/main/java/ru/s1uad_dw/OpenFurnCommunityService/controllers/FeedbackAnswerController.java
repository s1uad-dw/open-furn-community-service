package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.services.FeedbackAnswerService;
import ru.s1uad_dw.OpenFurnCommunityService.services.FeedbackService;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/community/feedback_answers")
public class FeedbackAnswerController {
    @Autowired
    private FeedbackAnswerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateFeedbackAnswerDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_token")
    public List<ViewFeedbackAnswerDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
