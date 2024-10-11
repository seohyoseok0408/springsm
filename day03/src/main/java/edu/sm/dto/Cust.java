package edu.sm.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cust {
    private String id;
    private String pwd;
    private String name;
}
