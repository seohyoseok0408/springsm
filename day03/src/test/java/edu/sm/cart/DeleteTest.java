package edu.sm.cart;

import edu.sm.app.service.CartService;
import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteTest {

    @Autowired
    CartService cartService;

    int id = 2;

    @Test
    public void testDelete() {
        try {
            cartService.del(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
