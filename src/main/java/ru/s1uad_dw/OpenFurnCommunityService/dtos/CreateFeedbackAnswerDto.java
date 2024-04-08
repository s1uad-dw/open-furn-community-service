package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.Data;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;

import java.util.Date;
import java.util.UUID;
@Data
public class CreateFeedbackAnswerDto {
    private UUID userId;
    private String text;
    private UUID feedbackId;
}
