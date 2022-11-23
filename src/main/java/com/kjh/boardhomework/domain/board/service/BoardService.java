package com.kjh.boardhomework.domain.board.service;

import com.kjh.boardhomework.domain.board.presentation.dto.request.BoardEditRequest;
import com.kjh.boardhomework.domain.board.presentation.dto.response.BoardInfoResponse;
import com.kjh.boardhomework.domain.board.presentation.dto.response.BoardResponse;

import java.util.List;

public interface BoardService {

    List<BoardResponse> listAllBoard();

    BoardInfoResponse getBoardById(Long feedId);

    void editBoard(BoardEditRequest request, Long feedId);

    void deleteBoard(Long feedId);
}
