package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.s1uad_dw.OpenFurnCommunityService.models.FeedbackAnswer;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ViewFeedbackDto {
    private UUID userId;
    private String text;
    private List<ViewFeedbackAnswerDto> answers;
    private int evaluation;
    private Date creationDate;
    private UUID projectId;
}
