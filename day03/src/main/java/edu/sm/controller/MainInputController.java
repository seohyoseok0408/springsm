package edu.sm.controller;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@Slf4j
public class MainInputController {

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
                            HttpSession session) {
        log.info("ID:"+id);
        log.info("PWD:"+pwd);
        String next = "redirect:/";
        if (id.equals("aaa") && pwd.equals("111")) {
            session.setAttribute("logined", id);
        } else {
            model.addAttribute("center", "loginfail");
            next = "index";
        }
        return next;
    }
}