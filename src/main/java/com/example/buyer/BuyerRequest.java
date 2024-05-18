package com.example.buyer;

import lombok.Data;

public class BuyerRequest {

    @Data
    public static class JoinDTO{
        private String buyerName;
        private String buyerPw;
        private String buyerEmail;
    }
}
