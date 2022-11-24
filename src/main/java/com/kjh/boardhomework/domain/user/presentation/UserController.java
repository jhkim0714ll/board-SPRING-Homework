package com.kjh.boardhomework.domain.user.presentation;

import com.kjh.boardhomework.domain.board.presentation.dto.request.BoardEditRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.JoinRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.response.LoginResponse;
import com.kjh.boardhomework.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(
            @ModelAttribute("loginRequest") LoginRequest loginRequest,
            BindingResult bindingResult,
            Model model) {


        if(bindingResult.hasErrors()) {
            model.addAttribute("loginRequest", new LoginRequest());
            return "user/login";
        }
        userService.login(loginRequest);
        return "redirect:/list";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("loginRequest") LoginRequest loginRequest,
                        BindingResult bindingResult,
                        Model model
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("loginRequest", loginRequest);
            return "user/login";
        }

        String token = userService.login(loginRequest);

        model.addAttribute("isLogin", token);
        return "redirect:/list";
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute("joinRequest") JoinRequest joinRequest,
                               BindingResult bindingResult,
                               Model model
    ){
        if(bindingResult.hasErrors()) {
            model.addAttribute("joinRequest", joinRequest);
            return "user/register";
        }

        userService.register(joinRequest);
        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "redirect:/user/login";
    }
}
