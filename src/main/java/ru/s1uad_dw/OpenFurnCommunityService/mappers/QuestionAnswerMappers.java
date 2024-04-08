package ru.s1uad_dw.OpenFurnCommunityService.mappers;

import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.models.Question;
import ru.s1uad_dw.OpenFurnCommunityService.models.QuestionAnswer;
import ru.s1uad_dw.OpenFurnCommunityService.models.QuestionAnswer;

public class QuestionAnswerMappers {
    public static QuestionAnswer CreateQuestionAnswerDtoToDao(CreateQuestionAnswerDto dto, Question Question){
        return new QuestionAnswer(
                dto.getUserId(),
                dto.getText(),
                Question
        );
    }

    public static ViewQuestionAnswerDto daoToViewQuestionAnswerDto(QuestionAnswer dao){
        return new ViewQuestionAnswerDto(
                dao.getUserId(),
                dao.getText(),
                dao.getCreationDate()
        );
    }
}
