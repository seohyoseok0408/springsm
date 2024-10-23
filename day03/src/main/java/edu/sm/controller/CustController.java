package edu.sm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Search;
import edu.sm.app.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {

    final CustService custService;

    String dir = "cust/";

    @RequestMapping("")
    public String cust(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) throws Exception {
        CustDto custDto = null;
        custDto = custService.get(id);
        model.addAttribute("cust",custDto);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<CustDto> custs = null;
        custs = custService.get();
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        model.addAttribute("custs", custs);
        return "index";
    }

    @RequestMapping("/getpage")
    public String getpage(Model model, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) throws Exception {
        PageInfo<CustDto> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo), 5);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("cpage", p);
        model.addAttribute("target", "/cust");
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"page");
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
        PageInfo<CustDto> p;
        try {
            p = new PageInfo<>(custService.getFindPage(search, pageNo), 3);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("cpage", p);
        model.addAttribute("target", "cust");

        model.addAttribute("search", search);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"search");
        return "index";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model,
                             CustDto custDto) throws Exception {
        custService.modify(custDto);
        return "redirect:/car/detail?id="+custDto.getCustId();
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model,
                             @RequestParam("id") String id) throws Exception {
        custService.del(id);
        return "redirect:/car/info";
    }
}