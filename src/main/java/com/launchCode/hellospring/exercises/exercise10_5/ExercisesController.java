package com.launchCode.hellospring.exercises.exercise10_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class ExercisesController {
    //create different messages
    public static String createMessage(String name, String language) {
        String greeting = switch (language) {
            case "French" -> "Bonjour ";
            case "Chinese" -> "你好 ";
            case "German" -> "Hallo ";
            case "Spanish" -> "Hola ";
            default -> "Hello ";
        };

        return greeting + name + "!";
    }

    //mapping to /greeting
    @RequestMapping(value = "greeting", method = RequestMethod.POST)
    @ResponseBody
    public String helloMessage(@RequestParam String name, @RequestParam String language) {
        if(Objects.equals(name, "")) {
            name = "World";
        }
        return createMessage(name, language);
    }

    //mapping to /form
    @GetMapping("helloForm")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method='post' action='greeting'>" +
                "<input type='text' name='name'/>" +
                "<select name='language'>" +
                "<option value='English' selected>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Chinese'>Chinese</option>" +
                "<option value='German'>German</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<button type='submit'>Greet me</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
