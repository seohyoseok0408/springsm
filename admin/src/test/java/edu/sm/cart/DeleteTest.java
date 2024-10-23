package edu.sm.cart;

import edu.sm.app.dto.CartDto;
import edu.sm.app.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteTest {

    @Autowired
    CartService cartService;

    CartDto cartDto = CartDto.builder()
            .cartUserId("cust001")
            .cartItemId(1)
            .build();

    @Test
    public void testDelete() {
        try {
            cartService.del(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
