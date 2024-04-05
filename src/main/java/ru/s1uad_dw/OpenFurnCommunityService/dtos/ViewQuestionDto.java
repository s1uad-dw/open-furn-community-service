package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
public class ViewQuestionDto {
    private UUID userId;
    private String text;
    private List<ViewQuestionAnswerDto> answers;
    private Date creationDate;
    private UUID projectId;
}
