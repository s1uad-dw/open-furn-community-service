package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.Data;
import ru.s1uad_dw.OpenFurnCommunityService.models.Question;

import java.util.UUID;
@Data
public class CreateQuestionAnswerDto {
    private UUID userId;
    private String text;
    private UUID questionId;
}
