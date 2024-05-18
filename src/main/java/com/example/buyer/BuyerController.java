package com.example.buyer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BuyerController {

    @GetMapping("/")
    public String list(){
        return "product/list";
    }
}
