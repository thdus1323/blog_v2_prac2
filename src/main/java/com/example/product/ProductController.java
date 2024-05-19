package com.example.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    //상품목록구현하기
    @GetMapping({"/product","/"})
    public String list(HttpServletRequest request){
        List<ProductResponse.ListDTO> productList =
                productService.getProductList();
        request.setAttribute("productList", productList);
//        System.out.print("상품 구현 : " + productList);
        return "product/list";

    }
}
