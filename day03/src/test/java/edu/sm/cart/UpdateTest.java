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
public class UpdateTest {

    @Autowired
    CartService cartService;

    CartDto cartDto;

    int id = 4;

    @Test
    public void testUpdate() {
        try {
            cartDto = cartService.get(id);
            cartDto.setCount(10);

            cartService.modify(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
