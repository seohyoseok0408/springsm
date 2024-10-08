package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/map")
public class MapController {

    String dir = "js/";

    @RequestMapping("")
    public String map(Model model) {
        model.addAttribute("left",  dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }
    @RequestMapping("/js1")
    public String map1(Model model) {
        model.addAttribute("left",  dir+"left");
        model.addAttribute("center", dir+"map1");
        return "index";
    }
    @RequestMapping("/map2")
    public String map2(Model model) {
        model.addAttribute("left",  dir+"left");
        model.addAttribute("center", dir+"map2");
        return "index";
    }
    @RequestMapping("/map3")
    public String map3(Model model) {
        model.addAttribute("left",  dir+"left");
        model.addAttribute("center", dir+"map3");
        return "index";
    }
}
