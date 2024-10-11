package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class AjaxRestController {

    @RequestMapping("/getctime")
    public Object getcTime() {
        JSONObject obj = new JSONObject();
        // {'ctime', '2023-01-01'}
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd(E) a HH:mm:ss");
        String formattedTime = now.format(formatter);

        obj.put("ctime", formattedTime);
        return obj;
    }
}
