package ru.s1uad_dw.OpenFurnCommunityService.mappers;

import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;

import java.util.UUID;

public class FeedbackMappers {
    public static Feedback CreateFeedbackDtoToDao(CreateFeedbackDto dto){
        return new Feedback(
                dto.getUserId(),
                dto.getText(),
                dto.getEvaluation(),
                dto.getProjectId()
        );
    }

    public static ViewFeedbackDto daoToViewFeedbackDto(Feedback dao){
        return new ViewFeedbackDto(
                dao.getUserId(),
                dao.getText(),
                dao.getAnswers().stream().map(FeedbackAnswerMappers::daoToViewFeedbackAnswerDto).toList(),
                dao.getEvaluation(),
                dao.getCreationDate(),
                dao.getProjectId()
        );
    }
}
