package ru.s1uad_dw.OpenFurnCommunityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;
import ru.s1uad_dw.OpenFurnCommunityService.models.Question;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findByProjectId(UUID projectId);
    Optional<Question> findByUserId(UUID userId);
}
