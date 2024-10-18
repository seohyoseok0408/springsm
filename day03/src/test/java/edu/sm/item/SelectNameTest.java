package edu.sm.item;

import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectNameTest {

    @Autowired
    ItemService itemService;

    String name = "up";

    @Test
    public void testSelectName() {
        try {
            itemService.getByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
