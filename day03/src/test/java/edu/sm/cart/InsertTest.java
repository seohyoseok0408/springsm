package edu.sm.cart;

import edu.sm.app.dto.CartDto;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.service.CartService;
import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class InsertTest {

    @Autowired
    CartService cartService;

    @Test
    public void testInsert() {
        try {
            CartDto cartDto = CartDto.builder()
                    .cartUserId("cust001")
                    .cartItemId(1)
                    .cartCount(3)
                    .build();
            cartService.add(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
