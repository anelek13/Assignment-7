package edu.education.syslib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String welcomePage() {
        return "index";
    }
}
