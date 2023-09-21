package com.poly.truongnvph29176.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginUserController {

    @GetMapping("/loginPage")
    public String login() {
        return "user/index";
    }
}
