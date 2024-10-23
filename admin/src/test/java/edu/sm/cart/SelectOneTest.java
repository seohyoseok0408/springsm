package edu.sm.cart;

import edu.sm.app.dto.CartDto;
import edu.sm.app.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectOneTest {

    @Autowired
    CartService cartService;

    CartDto cartDto = CartDto.builder()
            .cartUserId("cust001")
            .cartItemId(1)
            .build();

    @Test
    public void testSelectOne() {
        try {
            cartDto = cartService.get(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
