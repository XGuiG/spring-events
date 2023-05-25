package com.launchCode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    // mapping to /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //mapping to /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye Spring!";
    }

    //mapping to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //mapping to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPath(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //mapping to /form?name=LaunchCode
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    //mapping to /hello-list with list
    @GetMapping("hello-list")
    public String helloList(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("JavaScript");
        names.add("Python");
        model.addAttribute("names", names);
        return "list";
    }
}
