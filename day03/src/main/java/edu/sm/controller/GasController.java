package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GasController {

    // GET 요청 처리
    @RequestMapping("/gas")
    public int gas(@RequestBody Integer data) {
        log.info("가스량:" + data);
        return 1;
    }
}
