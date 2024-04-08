package ru.s1uad_dw.OpenFurnCommunityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.OpenFurnCommunityService.models.Feedback;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findByProjectId(UUID projectId);
    Optional<Feedback> findByUserId(UUID userId);
}
