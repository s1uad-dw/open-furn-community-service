package ru.s1uad_dw.OpenFurnCommunityService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String text;
    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedbackAnswer> answers;
    private int evaluation;
    private Date creationDate;
    private UUID projectId;

    public Feedback(UUID userId, String text, int evaluation, UUID projectId){
        this.userId = userId;
        this.text = text;
        this.answers = new ArrayList<>();
        this.evaluation = evaluation;
        this.creationDate = new Date();
        this.projectId = projectId;
    }
}
