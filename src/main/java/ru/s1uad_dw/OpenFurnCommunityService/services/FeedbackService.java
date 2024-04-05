package ru.s1uad_dw.OpenFurnCommunityService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackDto;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.InvalidDataException;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.ResourceNotFoundException;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.FeedbackAnswerMappers;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.FeedbackMappers;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;
import ru.s1uad_dw.OpenFurnCommunityService.models.FeedbackAnswer;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.FeedbackAnswerRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.FeedbackRepository;
import ru.s1uad_dw.OpenFurnCommunityService.utils.TokenUtility;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repository;
    @Autowired
    private TokenUtility tokenUtility;


    public UUID create(String token, CreateFeedbackDto dto){
        tokenUtility.checkTokenExpiration(token);
        if (dto.getEvaluation()<=5 && dto.getEvaluation()>=1)
            return repository.save(FeedbackMappers.CreateFeedbackDtoToDao(dto)).getId();
        throw new InvalidDataException("Invalid evaluation");
    }

    public List<ViewFeedbackDto> findByProjectId(UUID projectId){
        return repository.findByProjectId(projectId).stream().map(FeedbackMappers::daoToViewFeedbackDto).toList();
    }

    public List<ViewFeedbackDto> findByToken(String token){
        tokenUtility.checkTokenExpiration(token);
        return repository.findByUserId(tokenUtility.getId(token))
                .stream().map(FeedbackMappers::daoToViewFeedbackDto).toList();
    }
}
