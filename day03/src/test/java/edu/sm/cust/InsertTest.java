package edu.sm.cust;

import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class InsertTest {

    @Autowired
    CustService custService;

    @Test
    void contextLoads() {
       try {
           CustDto custDto = CustDto.builder()
                   .id("id05")
                   .pwd("1234")
                   .name("seohyoseok")
                   .build();
           custService.add(custDto);
       } catch (Exception e) {
              throw new RuntimeException(e);
       }
    }
}
