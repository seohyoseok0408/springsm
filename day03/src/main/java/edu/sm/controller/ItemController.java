package edu.sm.controller;

import com.github.pagehelper.PageInfo;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.dto.Search;
import edu.sm.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    String dir = "item/";

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("")
    public String item(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model) throws Exception {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"search");
        return "index";
    }

    @RequestMapping("/findimpl")
    public String findimpl(Model model, Search search, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) throws Exception {
        log.info("search: "+search.toString());
        PageInfo<ItemDto> i;
        try {
            i = new PageInfo<>(itemService.getFindPage(search, pageNo), 3);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("cpage", i);
        model.addAttribute("target", "item");

        model.addAttribute("search", search);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"search");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id) throws Exception {
        ItemDto itemDto = null;
        itemDto = itemService.get(id);
        model.addAttribute("item",itemDto);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";
    }
}