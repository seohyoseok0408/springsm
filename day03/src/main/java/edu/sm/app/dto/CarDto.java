package edu.sm.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int carId;
    private String carModel;
    private String imgName;
    private long carPrice;
    private LocalDateTime regDate;
}