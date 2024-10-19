package edu.sm.cart;

import edu.sm.app.dto.CartDto;
import edu.sm.app.service.CartService;
import edu.sm.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectOneTest {

    @Autowired
    CartService cartService;

    CartDto cartDto;
    int id = 4;

    @Test
    public void testSelectOne() {
        try {
            cartDto = cartService.get(id);
            log.info("cartDto: {}", cartDto);
            System.out.println("HEREHERE!!!!!");
            System.out.println(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
