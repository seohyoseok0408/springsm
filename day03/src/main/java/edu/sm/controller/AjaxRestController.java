package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    @RequestMapping("/getranktitle")
    public Object getRankTitle() {
        JSONArray arr = new JSONArray();
        String[] descriptions = {"검색어1", "검색어2", "검색어3", "검색어4", "검색어5"};  // 설명 타이틀 목록

        List<String> descriptionList = Arrays.asList(descriptions);
        Collections.shuffle(descriptionList);  // 리스트를 무작위로 섞음
        for (int i=1; i<6; i++) {
            JSONObject obj = new JSONObject();
            obj.put("no", i);
            obj.put("desc", descriptionList.get(i - 1));
            arr.add(obj);
        }
        return arr;
    }
}
