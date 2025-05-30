package com.cw.cwu.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "created_at")
    private LocalDate questionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "view_count")
    private int viewCount;

    public void editTitle(String title){this.title=title;}
    public void editContent(String content){this.content=content;}
}
