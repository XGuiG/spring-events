package com.launchCode.hellospring.studios.studio10_6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {
    @GetMapping("skills")
    @ResponseBody
    public String home() {
        String h1 = "<h1>Skills Tracker</h1>";
        String h2 = "<h2>We have a few skills we would like to learn. Here is the list!";
        String list = "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>";
        return "<html>" +
                "<body>" +
                h1 + h2 + list +
                "</body>" +
                "</html>";
    }

    @GetMapping("skillForm")
    @ResponseBody
    public String form() {
        String options = "<option value='Java' selected>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Python'>Python</option>";
        return "<html>" +
                "<body>" +
                "<form action='/person' method='post'>" +
                "Name: <input type='text' name='name'/><br>" +
                "My favorite language: <select name='first'>" +
                options + "</select><br>" +
                "My second favorite language: <select name='second'>" +
                options + "</select><br>" +
                "My third favorite language: <select name='third'>" +
                options + "</select><br>" +
                "<button type='submit'>Submit</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public String formResponse(@RequestParam String name, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        return "<html>" +
                "<body>" +
                "<h2>" + name + "</h2>" +
                "<table>" +
                "<tr><th>Favorite Level</th><th>Language</th></tr>" +
                "<tr><td>First</td><td>" + first + "</td></tr>" +
                "<tr><td>Second</td><td>" + second + "</td></tr>" +
                "<tr><td>Third</td><td>" + third + "</td></tr>" +
                "</table>" +
                "</body>" +
                "</html>";
    }
}
