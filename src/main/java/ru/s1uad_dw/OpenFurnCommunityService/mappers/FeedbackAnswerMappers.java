package ru.s1uad_dw.OpenFurnCommunityService.mappers;

import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;
import ru.s1uad_dw.OpenFurnCommunityService.models.FeedbackAnswer;

public class FeedbackAnswerMappers {
    public static FeedbackAnswer CreateFeedbackAnswerDtoToDao(CreateFeedbackAnswerDto dto, Feedback feedback){
        return new FeedbackAnswer(
                dto.getUserId(),
                dto.getText(),
                feedback
        );
    }

    public static ViewFeedbackAnswerDto daoToViewFeedbackAnswerDto(FeedbackAnswer dao){
        return new ViewFeedbackAnswerDto(
                dao.getUserId(),
                dao.getText(),
                dao.getCreationDate()
        );
    }
}
