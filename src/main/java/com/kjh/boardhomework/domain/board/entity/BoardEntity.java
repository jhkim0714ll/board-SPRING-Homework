package com.kjh.boardhomework.domain.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity(name = "board_entity")
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String authorName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private int readCount;

    public void addReadCount() {
        this.readCount++;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public BoardEntity(String title, String content, String authorName, LocalDateTime createdAt, int readCount) {
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.readCount = readCount;
    }
}
