package com.kjh.boardhomework.domain.user.presentation;

import com.kjh.boardhomework.domain.user.presentation.dto.request.RegisterRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String message,
            HttpServletRequest request
    ) {
        if(error != null) {
            if(error.equals("true")) {
                request.setAttribute("exception", message);
            }
        }
        return "user/login";
    }

    @PostMapping("/login")
    public String login(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ) {
        LoginRequest loginRequest = new LoginRequest(id, password);

        String token = userService.login(loginRequest);

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(1000  * 60 * 60);
        response.addCookie(cookie);
        return "redirect:/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        request.setAttribute("login", false);
        return "redirect:/list";
    }


    @GetMapping("/register")
    public String registerPage(){
        return "user/register";
    }

    @PostMapping("/register")
    public String register(
            HttpServletRequest request,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("password") String password
    ){
        RegisterRequest registerRequest = new RegisterRequest(id, name, password);
        String result = userService.register(registerRequest);
        if(result.equals("alreadyExistsId")) {
            request.setAttribute("alreadyExistsId", true);
            return "user/register";
        }
        return "redirect:/user/login";
    }
}
