package com.example.buyer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Repository
public class BuyerRepository {
    private final EntityManager em;

    //1. 회원가입
    public void join(BuyerRequest.JoinDTO reqDTO) {
        Query query = em.createNativeQuery("""
                insert into buyer_tb(buyer_name, buyer_pw, buyer_email, created_at)
                values (?,?,?,now())
                """);
        query.setParameter(1, reqDTO.getBuyerName());
        query.setParameter(2, reqDTO.getBuyerPw());
        query.setParameter(3, reqDTO.getBuyerPw());
        query.executeUpdate();
    }

    //2. 로그인
    public Buyer login(BuyerRequest.LoginDTO reqDTO){
        Query query = em.createNativeQuery("select * from buyer_tb where buyer_name = ? and buyer_pw=?", Buyer.class);
        query.setParameter(1, reqDTO.getBuyerName());
        query.setParameter(2, reqDTO.getBuyerPw());
        Buyer sessionBuyer = (Buyer) query.getSingleResult();
        return sessionBuyer;
    }

}
