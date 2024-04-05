package ru.s1uad_dw.OpenFurnCommunityService.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.models.QuestionAnswer;

import java.util.List;
import java.util.UUID;

public interface QuestionAnswerRepository extends JpaRepositoryImplementation<QuestionAnswer, UUID> {
    List<QuestionAnswer> findByUserId(UUID id);
}
