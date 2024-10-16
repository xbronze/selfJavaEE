package com.dingli.chapter6experiment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xbronze
 * @date: 2024-10-16 08:41
 * @description: TODO
 */
@Controller
@RequestMapping("/learning")
public class LearningController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/spring")
    public String springPage() {
        return "spring";
    }

    @RequestMapping("/springmvc")
    public String springMVCPage() {
        return "springmvc";
    }
}
