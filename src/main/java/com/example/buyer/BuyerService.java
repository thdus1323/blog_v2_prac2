package com.example.buyer;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    //1. 회원가입
    @Transactional
    public void joinByNameAndPwAndEmail(BuyerRequest.JoinDTO reqDTO){
        buyerRepository.join(reqDTO);
    }

}
