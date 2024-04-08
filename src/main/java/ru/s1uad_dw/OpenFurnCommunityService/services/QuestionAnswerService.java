package ru.s1uad_dw.OpenFurnCommunityService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.InvalidDataException;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.QuestionAnswerMappers;
import ru.s1uad_dw.OpenFurnCommunityService.models.Question;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionAnswerRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionAnswerRepository;
import ru.s1uad_dw.OpenFurnCommunityService.utils.TokenUtility;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository repository;
    @Autowired
    private QuestionRepository QuestionRepository;

    @Autowired
    private TokenUtility tokenUtility;

    public UUID create(String token, CreateQuestionAnswerDto dto){
        tokenUtility.checkTokenExpiration(token);
        Optional<Question> Question = QuestionRepository.findById(dto.getQuestionId());
        if (Question.isEmpty())
            throw new InvalidDataException("Invalid Question");
        if (dto.getText().isBlank())
            throw new InvalidDataException("Invalid text");
        return repository.save(QuestionAnswerMappers.CreateQuestionAnswerDtoToDao(dto, Question.get())).getId();
    }

    public List<ViewQuestionAnswerDto> findByToken(String token){
        tokenUtility.checkTokenExpiration(token);
        return repository.findByUserId(tokenUtility.getId(token))
                .stream().map(QuestionAnswerMappers::daoToViewQuestionAnswerDto).toList();
    }
}
