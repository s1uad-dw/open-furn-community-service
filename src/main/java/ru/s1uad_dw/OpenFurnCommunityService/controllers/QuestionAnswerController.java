package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create question answer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New question answer id:UUID",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid question | text | token",
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
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateQuestionAnswerDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find question answers by token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required question answers",
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
    public List<ViewQuestionAnswerDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
