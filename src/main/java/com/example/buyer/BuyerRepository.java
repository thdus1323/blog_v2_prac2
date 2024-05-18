package com.example.buyer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BuyerRepository {
    private final EntityManager em;

    //회원가입
    public void join(BuyerRequest.JoinDTO reqDTO) {
        Query query = em.createNativeQuery("""
                insert into buyer_tb (buyer_name,buyer_pw,buyer_email,created_at) values (?,?,?,now())
                """);
        query.setParameter(1, reqDTO.getBuyerName());
        query.setParameter(2, reqDTO.getBuyerPw());
        query.setParameter(3, reqDTO.getBuyerEmail());
        query.executeUpdate();
    }
}
