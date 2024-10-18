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
public class UpdateTest {

    @Autowired
    CustService custService;

    String id = "cust001";
    @Test
    void contextLoads() {
        try {
            CustDto custDto = custService.get(id);
            custDto.setPwd("1234");
            custDto.setName("seohyoseok");
            custService.modify(custDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
