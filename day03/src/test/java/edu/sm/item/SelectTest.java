package edu.sm.item;

import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectTest {

    @Autowired
    ItemService itemService;

    @Test
    public void testSelect() {
        try {
            itemService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
