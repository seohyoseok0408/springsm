package edu.sm.controller;

import edu.sm.app.dto.CustDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cust")
public class CustController {

    String dir = "cust/";

    @RequestMapping("")
    public String cust(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model) {
        List<CustDto> custs = new ArrayList<>();
        custs.add(CustDto.builder().custId("id1").custPwd("pwd1").custName("name1").build());
        custs.add(CustDto.builder().custId("id2").custPwd("pwd2").custName("name2").build());
        custs.add(CustDto.builder().custId("id3").custPwd("pwd3").custName("name3").build());
        custs.add(CustDto.builder().custId("id4").custPwd("pwd4").custName("name4").build());
        custs.add(CustDto.builder().custId("id5").custPwd("pwd5").custName("name5").build());
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        model.addAttribute("custs",custs);
        return "index";
    }
}