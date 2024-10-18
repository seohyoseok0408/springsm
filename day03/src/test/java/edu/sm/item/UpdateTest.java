package edu.sm.item;

import edu.sm.app.dto.Item;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UpdateTest {

    @Autowired
    ItemService itemService;

    ItemDto itemDto;

    int id = 1;

    @Test
    public void testUpdate() {
        try {
            itemDto = itemService.get(id);
            itemDto.setItemName("updatedName");
            itemDto.setUpdateDate(LocalDate.now());

            itemService.modify(itemDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
