package ru.s1uad_dw.OpenFurnCommunityService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.CreateFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.ViewFeedbackAnswerDto;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.InvalidDataException;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.ResourceNotFoundException;
import ru.s1uad_dw.OpenFurnCommunityService.mappers.FeedbackAnswerMappers;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;
import ru.s1uad_dw.OpenFurnCommunityService.models.FeedbackAnswer;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.FeedbackAnswerRepository;
import ru.s1uad_dw.OpenFurnCommunityService.repositories.FeedbackRepository;
import ru.s1uad_dw.OpenFurnCommunityService.utils.TokenUtility;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackAnswerService {
    @Autowired
    private FeedbackAnswerRepository repository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private TokenUtility tokenUtility;

    public UUID create(String token, CreateFeedbackAnswerDto dto){
        tokenUtility.checkTokenExpiration(token);
        Optional<Feedback> feedback = feedbackRepository.findById(dto.getFeedbackId());
        if (feedback.isEmpty())
            throw new InvalidDataException("Invalid feedback");
        if (dto.getText().isBlank())
            throw new InvalidDataException("Invalid text");
        return repository.save(FeedbackAnswerMappers.CreateFeedbackAnswerDtoToDao(dto, feedback.get())).getId();
    }

    public List<ViewFeedbackAnswerDto> findByToken(String token){
        tokenUtility.checkTokenExpiration(token);
        return repository.findByUserId(tokenUtility.getId(token))
                .stream().map(FeedbackAnswerMappers::daoToViewFeedbackAnswerDto).toList();
    }
}
