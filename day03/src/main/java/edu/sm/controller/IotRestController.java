package edu.sm.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/iot")
public class IotRestController {
    @RequestMapping("/power")
    public Object power(@RequestBody String data) {
        log.info(data);
        return 1;
    }

    @GetMapping("/power/logs")
    public List<String> getPowerLogs() {
        List<String> logs = new ArrayList<>();
        String logFilePath = "/Users/hyoseokseo/dev/springsm/logs/power.log"; // 로그 파일 경로

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                logs.add(line);
            }
        } catch (Exception e) {
            log.error("Failed to read log file", e);
        }

        return logs;
    }
}