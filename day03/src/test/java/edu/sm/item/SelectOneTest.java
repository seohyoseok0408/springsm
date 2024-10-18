package edu.sm.item;

import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectOneTest {

    @Autowired
    ItemService itemService;

    int id = 1;

    @Test
    public void testSelectOne() {
        try {
            itemService.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
