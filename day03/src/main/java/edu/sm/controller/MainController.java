package edu.sm.controller;

import edu.sm.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.json.simple.parser.ParseException;
import java.io.IOException;

@Slf4j
@Controller
public class MainController {

    @Value("${app.key.wkey}")
    String wkey;

    @RequestMapping("/") // localhost:8099/ 으로 들어오면
    public String main(Model model) {
        log.info("Start Main....");
        return "index"; // views 폴더 아래에 있는 index.jsp 파일을 찾아서 화면에 띄워줌
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("center", "about");
        return "index";
    }

    @RequestMapping("/webcam")
    public String webcam(Model model) {
        model.addAttribute("center", "webcam");
        return "index";
    }

    @RequestMapping("/wh")
    @ResponseBody
    public Object wh(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather("108",wkey);
    }

}
