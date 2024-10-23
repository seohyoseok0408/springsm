package edu.sm.item;

import edu.sm.app.dto.ItemDto;
import edu.sm.app.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class InsertTest {

    @Autowired
    ItemService itemService;

    ItemDto itemDto = ItemDto.builder()
            .itemId(0)
            .itemName("아이템")
            .itemPrice(1000)
            .imgName("아이템이미지")
            .regDate(LocalDateTime.now())
            .build();

    @Test
    public void testInsert() {
        try {
            itemService.add(itemDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
