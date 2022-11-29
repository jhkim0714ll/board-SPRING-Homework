package com.kjh.boardhomework.domain.board.presentation;

import com.kjh.boardhomework.domain.board.presentation.dto.request.BoardEditRequest;
import com.kjh.boardhomework.domain.board.presentation.dto.response.BoardInfoResponse;
import com.kjh.boardhomework.domain.board.service.BoardService;
import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.global.annotation.AuthorizationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String mainPage() {
        return "redirect:/list";
    }

    @AuthorizationCheck
    @GetMapping("/write")
    public String writeBoardPage(
            @ModelAttribute("boardEditRequest") BoardEditRequest boardEditRequest,
            Model model,
            HttpServletRequest request
    ) {
        model.addAttribute("title", "게시글 작성");
        model.addAttribute("original", "write");
        model.addAttribute("boardEditRequest", new BoardEditRequest());
        return "board/write";
    }

    @AuthorizationCheck
    @PostMapping(value = "/write")
    public String writeBoard(
            @ModelAttribute("boardEditRequest") BoardEditRequest boardEditRequest,
            BindingResult bindingResult,
            Model model,
            HttpServletRequest request
    ) {
        model.addAttribute("title", "게시글 작성");
        model.addAttribute("original", "write");

        if(bindingResult.hasErrors()) {
            model.addAttribute("boardEditRequest", boardEditRequest);
            return "board/write";
        }

        boardService.editBoard(boardEditRequest, null);
        return "redirect:/list";
    }

    @AuthorizationCheck
    @GetMapping("/update/{boardId}")
    public String updateBoardPage(
            @ModelAttribute("boardEditRequest") BoardEditRequest boardEditRequest,
            @PathVariable(required = false) Long boardId,
                                 Model model
    ) {
        model.addAttribute("board", boardService.getBoardById(boardId));
        model.addAttribute("title", "게시글 수정");
        model.addAttribute("id", boardId);
        model.addAttribute("boardEditRequest", new BoardEditRequest());
        model.addAttribute("original", "update");
        return "board/update";
    }

    @AuthorizationCheck
    @PostMapping("/update/{boardId}")
    public String updateBoard(
            @PathVariable(required = false) Long boardId,
                             @ModelAttribute("boardEditRequest") BoardEditRequest boardEditRequest,
                             BindingResult bindingResult,
                             Model model
    ) {
        model.addAttribute("board", boardService.getBoardById(boardId));
        model.addAttribute("title", "게시글 수정");
        if(bindingResult.hasErrors()) {
            model.addAttribute("boardEditRequest", boardEditRequest);
            model.addAttribute("original", "update");
            return "board/update";
        }
        boardService.editBoard(boardEditRequest, boardId);

        return "redirect:/list";
    }

    @AuthorizationCheck
    @GetMapping("/list")
    public String listBoardPage(
            Model model,
            @RequestAttribute("user") UserEntity user
    ) {
        model.addAttribute("user", user);
        model.addAttribute("list", boardService.listAllBoard());
        model.addAttribute("original", "list");
        return "board/list";
    }

    @AuthorizationCheck
    @GetMapping("/view/{boardId}")
    public String viewBoardPage(@PathVariable Long boardId, Model model) {
        BoardInfoResponse boardInfoResponse = boardService.getBoardById(boardId);
        model.addAttribute("title", String.format("게시글: %s", boardInfoResponse.getTitle()));
        model.addAttribute("board", boardInfoResponse);
        model.addAttribute("original", "view");
        return "board/view";
    }

    @AuthorizationCheck
    @DeleteMapping("/delete/{boardId}")
    public @ResponseBody void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
