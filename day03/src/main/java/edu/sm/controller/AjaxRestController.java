package edu.sm.controller;

import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Marker;
import edu.sm.app.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AjaxRestController {

    final CustService custService;

    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("rid") String id) throws Exception{
        JSONObject obj = new JSONObject();
        CustDto custDto = null;
        custDto = custService.get(id);
        obj.put("result", "0");
        if (custDto != null) {
            obj.put("result", "1");
        }
        return obj;
    }

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

    @RequestMapping("/getmarkers")
    public Object getmarkers(@RequestParam("target") int target) {
        // RestController에서는 객체를 리턴하면 JSON으로 변환해서 응답함
        List<Marker> markers = new ArrayList<Marker>();
        if (target == 100) {
            markers.add(new Marker(37.564472, 126.990841, "순대국1", "ss1.jpg", 101));
            markers.add(new Marker(37.544472, 126.970841, "순대국2", "ss2.jpg", 101));
            markers.add(new Marker(37.564472, 126.970841, "순대국3", "ss3.jpg", 101));
        } else if (target == 200) {

        } else {

        }
        return markers;
    }

    @RequestMapping("/getbike")
    public Object getbike(){
        JSONObject obj = new JSONObject();
        double lat = 36.799165;
        double lng = 127.074981;
        Random r = new Random();
        float num = r.nextFloat(1);
        lat += num/10;
        lng += num/10;
        obj.put("lat", lat);
        obj.put("lng", lng);
        return obj;
    }
}








