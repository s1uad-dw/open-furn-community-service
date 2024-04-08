package ru.s1uad_dw.OpenFurnCommunityService.mappers;

import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.models.Question;

public class QuestionMappers {
    public static Question CreateQuestionDtoToDao(CreateQuestionDto dto){
        return new Question(
                dto.getUserId(),
                dto.getText(),
                dto.getProjectId());
    }

    public static ViewQuestionDto daoToViewQuestionDto(Question dao){
        return new ViewQuestionDto(
                dao.getUserId(),
                dao.getText(),
                dao.getAnswers().stream().map(QuestionAnswerMappers::daoToViewQuestionAnswerDto).toList(),
                dao.getCreationDate(),
                dao.getProjectId()
        );
    }
}
