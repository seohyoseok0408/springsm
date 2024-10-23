package edu.sm.cust;

import edu.sm.app.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectByNameTest {

    @Autowired
    CustService custService;

    String name = "hyo";

    @Test
    public void contextLoads() {
        try {
            custService.getByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
