package com.example.appointment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/view")
@Controller
public class ViewController {
    @RequestMapping(method = RequestMethod.GET, value = "/{path}.html")
    public String view(@PathVariable String path){
        return path;
    }
}
