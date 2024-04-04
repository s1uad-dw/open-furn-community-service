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
@Table(name="question_answers")
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String text;
    @ManyToOne
    private Question question;
    private Date creationDate = new Date();

    public QuestionAnswer(UUID userId, String text, Question question){
        this.userId = userId;
        this.text = text;
        this.question = question;
        this.creationDate = new Date();
    }
}
