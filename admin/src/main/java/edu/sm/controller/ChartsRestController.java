package edu.sm.controller;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.util.Random;

@RestController
@Slf4j
@RequestMapping("charts")
public class ChartsRestController {

    @Value("${app.dir.readlogdir}")
    String readlogdir;

    @RequestMapping("chart3")
    public Object chart3() throws Exception {
        String logfile = readlogdir + "/power.log";

        JSONObject result = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        JSONObject obj = new JSONObject();

        obj.put("name", "power");

        CSVReader reader = null;
        reader = new CSVReader(new FileReader(logfile));

        String [] lineData = null;
        JSONArray jsonArray1 = new JSONArray();
        JSONArray timeArray1 = new JSONArray();
        String endLine = "";
        String endTime = "";
        while((lineData = reader.readNext()) != null) {
            timeArray1.add(lineData[0]);
            jsonArray1.add(Double.parseDouble(lineData[1]));
            endTime = lineData[0];
            endLine = lineData[1];
        }

        obj.put("data", jsonArray1);

        jsonArray.add(obj);
        result.put("result", jsonArray);
        result.put("x", timeArray1);
        result.put("endtime", endTime);
        result.put("endline", Double.parseDouble(endLine));
//        log.info(result.toJSONString());
        return result;
    }
}
