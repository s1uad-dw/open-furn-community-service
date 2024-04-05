package ru.s1uad_dw.OpenFurnCommunityService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewQuestionDto;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.InvalidDataException;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.QuestionMappers;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.QuestionMappers;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionAnswerRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.QuestionRepository;
import ru.s1uad_dw.OpenFurnCommunityService.utils.TokenUtility;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;
    @Autowired
    private TokenUtility tokenUtility;


    public UUID create(String token, CreateQuestionDto dto){
        tokenUtility.checkTokenExpiration(token);
        return repository.save(QuestionMappers.CreateQuestionDtoToDao(dto)).getId();
    }

    public List<ViewQuestionDto> findByProjectId(UUID projectId){
        return repository.findByProjectId(projectId).stream().map(QuestionMappers::daoToViewQuestionDto).toList();
    }

    public List<ViewQuestionDto> findByToken(String token){
        tokenUtility.checkTokenExpiration(token);
        return repository.findByUserId(tokenUtility.getId(token))
                .stream().map(QuestionMappers::daoToViewQuestionDto).toList();
    }
}
