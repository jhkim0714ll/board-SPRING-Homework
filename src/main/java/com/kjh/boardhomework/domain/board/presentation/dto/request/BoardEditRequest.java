package com.kjh.boardhomework.domain.board.presentation.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BoardEditRequest {
    @NotBlank(message = "제목은 비어있을 수 없습니다")
    @Size(max = 100, message = "게시글 제목은 최대 100자까지만 가능합니다")
    private String title;

    @NotBlank(message = "글쓴이 이름은 비어있을 수 없습니다")
    @Size(max = 50, message = "글쓴이 이름은 최대 50자까지만 가능합니다")
    private String author;

    @NotBlank(message = "내용은 비어있을 수 없습니다")
    @Size(max = 1000, message = "게시글 내용은 최대 1,000자까지만 가능합니다")
    private String content;
}
