package edu.sm.cust;

import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectTest {

    @Autowired
    CustService custService;

    @Test
    void contextLoads() {
        try {
            // logbacksql을 이용하여 콘솔에 출력
            custService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
