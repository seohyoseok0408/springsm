package edu.sm.controller;

import edu.sm.app.dto.CartDto;
import edu.sm.app.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;

    @RequestMapping("/add")
    public String add(@RequestParam("custId") String custId, @RequestParam("itemId") Integer itemId) {
        log.info("custId: "+custId);
        log.info("itemId: "+itemId);
        try {
            CartDto cartDto = CartDto.builder()
                    .cartUserId(custId)
                    .cartItemId(itemId)
                    .cartCount(1)
                    .build();
            cartService.add(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/item/search";
    }
}
