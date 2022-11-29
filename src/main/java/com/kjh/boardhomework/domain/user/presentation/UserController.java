package com.kjh.boardhomework.domain.user.presentation;

import com.kjh.boardhomework.domain.user.presentation.dto.request.RegisterRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.service.UserService;
import com.kjh.boardhomework.global.annotation.AuthorizationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(
            HttpServletResponse response,
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ) {

        LoginRequest loginRequest = new LoginRequest(id, password);

        String token = userService.login(loginRequest);

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/list";
    }

    @AuthorizationCheck
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/user/login";
    }


    @GetMapping("/register")
    public String registerPage(){
        return "user/register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("password") String password
    ){
        RegisterRequest registerRequest = new RegisterRequest(id, name, password);
        userService.register(registerRequest);
        return "redirect:/user/login";
    }
}
