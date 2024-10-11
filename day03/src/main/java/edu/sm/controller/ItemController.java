package edu.sm.controller;

import edu.sm.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/item")
public class ItemController {

    String dir = "item/";

    @RequestMapping("")
    public String item(Model model) {
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
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().id(1).name("name1").price(1000).imgname("p1.jpg").regdate(LocalDate.parse("2021-01-01")).build());
        items.add(Item.builder().id(2).name("name2").price(2000).imgname("p2.jpg").regdate(LocalDate.parse("2021-02-02")).build());
        items.add(Item.builder().id(3).name("name3").price(3000).imgname("p3.jpg").regdate(LocalDate.parse("2021-03-03")).build());
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        model.addAttribute("items",items);
        return "index";
    }
}