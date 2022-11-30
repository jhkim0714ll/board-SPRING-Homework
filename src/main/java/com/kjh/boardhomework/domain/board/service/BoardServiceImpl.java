package com.kjh.boardhomework.domain.board.service;

import com.kjh.boardhomework.domain.board.entity.BoardEntity;
import com.kjh.boardhomework.domain.board.exception.BoardNotFoundException;
import com.kjh.boardhomework.domain.board.presentation.dto.request.BoardEditRequest;
import com.kjh.boardhomework.domain.board.presentation.dto.response.BoardInfoResponse;
import com.kjh.boardhomework.domain.board.presentation.dto.response.BoardResponse;
import com.kjh.boardhomework.domain.board.repository.BoardRepository;
import com.kjh.boardhomework.global.util.FormatterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    private final FormatterUtils formatterUtils;

    @Override
    @Transactional(readOnly = true)
    public List<BoardResponse> listAllBoard() {

        return boardRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(it -> BoardResponse.builder()
                        .id(it.getId())
                        .title(it.getTitle())
                        .author(it.getAuthorName())
                        .preview(formatterUtils.getPreviewString(it.getContent(), 30))
                        .readCount(it.getReadCount())
                        .createdAt(formatterUtils.formatDateTime(it.getCreatedAt()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BoardInfoResponse getBoardById(Long feedId) {
        BoardEntity feed = boardRepository.findById(feedId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        feed.addReadCount();
        return BoardInfoResponse.builder()
                .id(feed.getId())
                .author(feed.getAuthorName())
                .title(feed.getTitle())
                .createdAt(formatterUtils.formatDateTime(feed.getCreatedAt()))
                .content(feed.getContent())
                .readCount(feed.getReadCount())
                .build();
    }

    @Override
    @Transactional
    public void editBoard(BoardEditRequest request, Long feedId) {

        if(feedId == null) {
            BoardEntity board = BoardEntity.builder()
                    .title(request.getTitle())
                    .authorName(request.getAuthor().getName())
                    .content(request.getContent())
                    .readCount(0)
                    .build();
            boardRepository.save(board);
        } else {
            BoardEntity original = boardRepository.findById(feedId)
                            .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

            original.update(request.getTitle(), request.getContent());
        }
    }

    @Override
    @Transactional
    public void deleteBoard(Long feedId) {
        BoardEntity feed = boardRepository.findById(feedId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        boardRepository.delete(feed);
    }
}
