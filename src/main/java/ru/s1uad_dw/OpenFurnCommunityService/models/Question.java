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
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String text;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionAnswer> answers;
    private Date creationDate;
    private UUID project;

    public Question(UUID userId, String text, UUID project){
        this.userId = userId;
        this.text = text;
        this.answers = new ArrayList<>();
        this.creationDate = new Date();
        this.project = project;
    }
}