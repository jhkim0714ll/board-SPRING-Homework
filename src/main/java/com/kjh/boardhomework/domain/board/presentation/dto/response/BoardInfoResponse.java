package com.kjh.boardhomework.domain.board.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class BoardInfoResponse {
    private Long id;
    private String title;
    private String author;
    private String createdAt;
    private String content;
    private long readCount;
}
