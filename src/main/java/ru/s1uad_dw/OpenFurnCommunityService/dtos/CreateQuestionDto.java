package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.Data;

import java.util.UUID;
@Data
public class CreateQuestionDto {
    private UUID userId;
    private String text;
    private UUID projectId;
}
