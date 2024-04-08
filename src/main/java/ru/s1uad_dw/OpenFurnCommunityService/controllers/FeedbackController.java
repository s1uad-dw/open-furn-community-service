package ru.s1uad_dw.OpenFurnCommunityService.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create feedback")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New feedback id:UUID",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid evaluation | text | token",
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
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateFeedbackDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_project_id")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find feedbacks by project id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required feedbacks",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public List<ViewFeedbackDto> findByProjectId(@RequestParam UUID projectId){
        return service.findByProjectId(projectId);
    }

    @GetMapping("find_by_token")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find feedbacks by token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required feedbacks",
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
    public List<ViewFeedbackDto> findByToken(@RequestHeader("Authorization") String token){
        return service.findByToken(token);
    }

}
