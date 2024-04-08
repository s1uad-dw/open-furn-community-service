package ru.s1uad_dw.OpenFurnCommunityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;
import ru.s1uad_dw.OpenFurnCommunityService.models.FeedbackAnswer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, UUID> {
    List<FeedbackAnswer> findByFeedback(Feedback feedback);
    List<FeedbackAnswer> findByUserId(UUID userId);
}
