package edu.sm.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustDto {
    private String id;
    private String pwd;
    private String name;
}
