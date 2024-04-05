package ru.s1uad_dw.OpenFurnCommunityService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
@AllArgsConstructor
public class ViewFeedbackAnswerDto {
    private UUID userId;
    private String text;
    private Date creationDate;
}
