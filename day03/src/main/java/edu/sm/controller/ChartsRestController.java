package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
@RequestMapping("charts")
public class ChartsRestController {

    @RequestMapping("chart1")
    public Object chart1() {
        JSONArray jsonArray = new JSONArray();
        for(int i=1; i<=5; i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", "NAME"+i);
            Random r = new Random();
            JSONArray jsonArray1 = new JSONArray();
            for(int j=1; j<=12; j++) {
                jsonArray1.add(r.nextInt(40)+1);
            }
            obj.put("data", jsonArray1);
            jsonArray.add(obj);
        }
        return jsonArray;
    }

    @RequestMapping("chart2")
    public Object chart2(@RequestParam("year") int year) {
        JSONArray jsonArray2020Men = new JSONArray();
        JSONArray jsonArray2021Men = new JSONArray();
        JSONArray jsonArray2022Men = new JSONArray();
        JSONArray jsonArray2023Men = new JSONArray();
        JSONArray jsonArray2024Men = new JSONArray();

        JSONArray jsonArray2020Women = new JSONArray();
        JSONArray jsonArray2021Women = new JSONArray();
        JSONArray jsonArray2022Women = new JSONArray();
        JSONArray jsonArray2023Women = new JSONArray();
        JSONArray jsonArray2024Women = new JSONArray();

        int[] data2020Men = {250000, 310000, 420000, 580000, 640000, 390000, 720000, 530000, 470000, 690000, 510000, 800000};
        int[] data2021Men = {270000, 350000, 440000, 600000, 660000, 420000, 740000, 550000, 490000, 710000, 530000, 820000};
        int[] data2022Men = {260000, 340000, 430000, 590000, 650000, 410000, 735000, 545000, 485000, 705000, 525000, 815000};
        int[] data2023Men = {280000, 360000, 450000, 610000, 670000, 430000, 750000, 560000, 500000, 720000, 540000, 830000};
        int[] data2024Men = {290000, 370000, 460000, 620000, 680000, 440000, 760000, 570000, 510000, 730000, 550000, 840000};

        int[] data2020Women = {150000, 100000, 310000, 460000, 500000, 170000, 200000, 370000, 150000, 580000, 300000, 400000};
        int[] data2021Women = {130000, 120000, 330000, 490000, 520000, 190000, 230000, 400000, 180000, 590000, 320000, 420000};
        int[] data2022Women = {140000, 130000, 300000, 480000, 510000, 180000, 220000, 380000, 160000, 570000, 310000, 410000};
        int[] data2023Women = {160000, 140000, 340000, 500000, 530000, 200000, 240000, 410000, 190000, 600000, 330000, 440000};
        int[] data2024Women = {170000, 150000, 350000, 510000, 540000, 210000, 250000, 420000, 200000, 610000, 340000, 450000};

        for (int i = 0; i < 12; i++) {
            jsonArray2020Men.add(data2020Men[i]);
            jsonArray2021Men.add(data2021Men[i]);
            jsonArray2022Men.add(data2022Men[i]);
            jsonArray2023Men.add(data2023Men[i]);
            jsonArray2024Men.add(data2024Men[i]);
        }

        for (int i = 0; i < 12; i++) {
            jsonArray2020Women.add(data2020Women[i]);
            jsonArray2021Women.add(data2021Women[i]);
            jsonArray2022Women.add(data2022Women[i]);
            jsonArray2023Women.add(data2023Women[i]);
            jsonArray2024Women.add(data2024Women[i]);
        }
        JSONArray jsonArray = new JSONArray();
        for(int i=1; i<=2; i++) {
            String gender;
            String color;
            JSONObject obj = new JSONObject();
            if (i == 1) {
                gender = "남자";
                color = "Lightskyblue";
                if (year == 2020) {
                    obj.put("data", jsonArray2020Men);
                } else if (year == 2021) {
                    obj.put("data", jsonArray2021Men);
                } else if (year == 2022) {
                    obj.put("data", jsonArray2022Men);
                } else if (year == 2023) {
                    obj.put("data", jsonArray2023Men);
                } else if (year == 2024) {
                    obj.put("data", jsonArray2024Men);
                }
            } else {
                gender = "여자";
                color = "pink";
                if (year == 2020) {
                    obj.put("data", jsonArray2020Women);
                } else if (year == 2021) {
                    obj.put("data", jsonArray2021Women);
                } else if (year == 2022) {
                    obj.put("data", jsonArray2022Women);
                } else if (year == 2023) {
                    obj.put("data", jsonArray2023Women);
                } else if (year == 2024) {
                    obj.put("data", jsonArray2024Women);
                }
            }
            obj.put("name", gender);
            obj.put("color", color);
            jsonArray.add(obj);
        }
        return jsonArray;
    }
}
