package com.example.buyer;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BuyerController {
    private final BuyerService buyerService;
    private final HttpSession session;

    //0. 메인페이지 구현
    @GetMapping("/")
    public String list(){
        return "product/list";
    }

    //1. 회원가입
    @PostMapping("/buyer/join")
    public String join(BuyerRequest.JoinDTO reqDTO){
        buyerService.joinByNameAndPwAndEmail(reqDTO);
        System.out.println("회원가입 : " + reqDTO);
        return "/buyer/login-form"; // 이후 로그인 폼으로 수정
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "buyer/join-form";
    }

    //2. 로그인
    @PostMapping("/login")
    public String login(BuyerRequest.LoginDTO reqDTO){
        Buyer sessionBuyer = buyerService.loginByNameAndPw(reqDTO);
        session.setAttribute("sessionBuyer", sessionBuyer);
        return "redirect:/";
    }

    @GetMapping("/buyer/login-form")
    public String loginForm(){
        return "buyer/login-form";
    }



}
