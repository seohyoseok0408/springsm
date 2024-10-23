package edu.sm.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class SMExceptionHandler {

    @ExceptionHandler(value = DuplicateKeyException.class)
    public String ex2(Model model, DuplicateKeyException e) {
        model.addAttribute("msg", "중복된 ID가 있습니다.");
        model.addAttribute("center", "error");
        return "index";
    }


    @ExceptionHandler(value = Exception.class)
    public String ex1(Model model, Exception e) {
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("center", "error");
        return "index";
    }
}
