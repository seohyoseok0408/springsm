package edu.sm.cart;

import edu.sm.app.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectTest {

    @Autowired
    CartService cartService;

    @Test
    public void testSelect() {
        try {
            cartService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
