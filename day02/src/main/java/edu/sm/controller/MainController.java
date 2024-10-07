package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

    @RequestMapping("/") // localhost:8099/ 으로 들어오면
    public String main(Model model) {
        log.info("Start Main....");
        model.addAttribute("name", "Spring Boot");
        model.addAttribute("msg", "Hello, Spring Boot with Gradle");
        return "index"; // views 폴더 아래에 있는 index.jsp 파일을 찾아서 화면에 띄워줌
    }
}
