package com.example.buyer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BuyerController {
    private final BuyerService buyerService;

    @GetMapping("/")
    public String list(){
        return "product/list";
    }

    @PostMapping("/buyer/join")
    public String join(BuyerRequest.JoinDTO reqDTO){
        buyerService.joinByNameAndPwAndEmail(reqDTO);
        System.out.println("회원가입 : " + reqDTO);
        return "product/list"; // 이후 로그인 폼으로 수정
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "buyer/join-form";
    }


}
