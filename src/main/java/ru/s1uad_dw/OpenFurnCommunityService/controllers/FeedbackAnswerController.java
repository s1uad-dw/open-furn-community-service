package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create feedback answer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New feedback answer id:UUID",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid feedback | text | token",
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
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateFeedbackAnswerDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find feedback answers by token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required feedback answers",
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
    public List<ViewFeedbackAnswerDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }
}
