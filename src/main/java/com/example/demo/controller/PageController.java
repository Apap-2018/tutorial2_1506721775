package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/viral/challenge")
    public String challange(@RequestParam(value="name", required=false, defaultValue = "kiki") String name, Model model) {
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping(value = {"/challenge", "/challenge/{name}"})
    public String challangePath(@PathVariable Optional<String> name, Model model) {
        if(name.isPresent()) {
            model.addAttribute("name", name.get());
        } else {
            model.addAttribute("name", "KB");
        }

        return "challenge";
    }

    @RequestMapping("/generator")
    public String generator(@RequestParam(value = "a",  required=false, defaultValue = "0") int a,
                            @RequestParam(value = "b",  required=false, defaultValue = "0") int b,
                            Model model) {
        String output = "hm";
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        while(a > 1) {
            output = output + "m";
            a--;
        } while (b > 1) {
            output +=  " " + output;
            b--;
        }

        model.addAttribute("output", output);

        return "generator";
    }
}

