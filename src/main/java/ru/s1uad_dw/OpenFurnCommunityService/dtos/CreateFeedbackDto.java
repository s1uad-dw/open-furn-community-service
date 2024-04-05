package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.Data;

import java.util.UUID;
@Data
public class CreateFeedbackDto {
    private UUID userId;
    private String text;
    private int evaluation;
    private UUID projectId;
}
