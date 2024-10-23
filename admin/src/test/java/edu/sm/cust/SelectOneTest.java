package edu.sm.cust;

import edu.sm.app.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectOneTest {

    @Autowired
    CustService custService;

    String id = "cust002";

    @Test
    void contextLoads() {
        try {
            custService.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
