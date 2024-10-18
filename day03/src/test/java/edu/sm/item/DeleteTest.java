package edu.sm.item;

import edu.sm.app.dto.ItemDto;
import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DeleteTest {

    @Autowired
    ItemService itemService;

    int id = 4;

    @Test
    public void testDelete() {
        try {
            itemService.del(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
