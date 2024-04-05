package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.services.QuestionService;
import ru.s1uad_dw.OpenFurnCommunityService.services.QuestionService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/community/questions")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateQuestionDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_project_id")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewQuestionDto> findByProjectId(@RequestParam UUID projectId){
        return service.findByProjectId(projectId);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewQuestionDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
