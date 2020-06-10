package com.lingyun.study.springsecurity.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SecurityController {
    @RequestMapping("/user/detail/{id}")
    public String userDetail(@PathVariable String id, ModelMap map) {
        map.addAttribute("id",id);
        return "/userDetail";
    }
}


