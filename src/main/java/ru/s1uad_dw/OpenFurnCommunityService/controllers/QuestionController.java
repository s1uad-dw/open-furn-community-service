package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create question")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New question id:UUID",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid text | token",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "401",
                    description = "Token expired",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateQuestionDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_project_id")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find questions by project id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required questions",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public List<ViewQuestionDto> findByProjectId(@RequestParam UUID projectId){
        return service.findByProjectId(projectId);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find questions by token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required questions",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid token",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "401",
                    description = "Token expired",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public List<ViewQuestionDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
