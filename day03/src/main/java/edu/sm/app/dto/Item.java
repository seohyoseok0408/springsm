package edu.sm.app.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Builder
public class Item {
    private int id;
    private String name;
    private int price;
    private String imgname;
    private LocalDate regdate;
}
