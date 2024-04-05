package ru.s1uad_dw.OpenFurnCommunityService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="feedback_answers")
public class FeedbackAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String text;
    @ManyToOne
    private Feedback feedback;
    private Date creationDate;

    public FeedbackAnswer(UUID userId, String text, Feedback feedback){
        this.userId = userId;
        this.text = text;
        this.feedback = feedback;
        this.creationDate = new Date();
    }
}
