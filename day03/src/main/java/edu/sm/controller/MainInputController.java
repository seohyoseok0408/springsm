package edu.sm.controller;
import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainInputController {

    final CustService custService;

    @RequestMapping("/logoutimpl")
    public String logoutimpl(HttpSession session, Model model){
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("id") String id,
                            @RequestParam("pwd") String pwd,
                            HttpSession session) throws Exception {
        log.info("ID:"+id);
        log.info("PWD:"+pwd);
        String next = "redirect:/";
        CustDto custDto = null;
        custDto = custService.get(id); // id로 검색된 Cust 정보
        if (custDto != null && custDto.getCustPwd().equals(pwd)) {
            session.setAttribute("loginid", custDto);
        } else {
            model.addAttribute("center", "loginfail");
            next = "index";
        }
        return next;
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               CustDto custDto,
                            HttpSession session) throws DuplicateKeyException, Exception {
        log.info("Cust Info:" + custDto.toString());

        try {
            custService.add(custDto);
        } catch (DuplicateKeyException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        session.setAttribute("loginid", custDto); // 자동로그인
        model.addAttribute("center", "registerok");
        return "index";
    }


}