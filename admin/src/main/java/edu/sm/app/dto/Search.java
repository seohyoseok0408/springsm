package edu.sm.app.dto;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Search {
    private String keyword;
    private String search;
}
