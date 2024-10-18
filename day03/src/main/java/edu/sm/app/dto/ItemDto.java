package edu.sm.app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ItemDto {
    private int itemId;
    private String itemName;
    private long itemPrice;
    private String imgName;
    private LocalDate regDate;
    private LocalDate updateDate;
}