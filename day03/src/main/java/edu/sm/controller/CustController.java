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
        custs.add(CustDto.builder().id("id1").pwd("pwd1").name("name1").build());
        custs.add(CustDto.builder().id("id2").pwd("pwd2").name("name2").build());
        custs.add(CustDto.builder().id("id3").pwd("pwd3").name("name3").build());
        custs.add(CustDto.builder().id("id4").pwd("pwd4").name("name4").build());
        custs.add(CustDto.builder().id("id5").pwd("pwd5").name("name5").build());
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        model.addAttribute("custs",custs);
        return "index";
    }
}