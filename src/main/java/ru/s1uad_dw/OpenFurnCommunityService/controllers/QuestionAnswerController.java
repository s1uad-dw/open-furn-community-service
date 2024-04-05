package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.services.QuestionAnswerService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/community/question_answers")
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateQuestionAnswerDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_token")
    public List<ViewQuestionAnswerDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
