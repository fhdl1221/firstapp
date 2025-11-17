package com.example.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        String name = "gyuri";
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("username", "kim");
        model.addAttribute("age", 20);
        model.addAttribute("city", "seoul");

        return "user";
    }

    @GetMapping("/fruits")
    public String fruits(Model model){
        List<String> fruitList = new ArrayList<>();
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        fruitList.add("kiwi");
        fruitList.add("pineapple");

        model.addAttribute("fruits", fruitList);
        return "fruits";
    }

    @GetMapping("/grade")
    public String grade(Model model){
        int score = 80;
        model.addAttribute("score", score);
        return "grade";
    }

    @GetMapping("/lunch")
    public String lunch(Model model){
        List<String> menus = Arrays.asList("김밥", "라면", "돈가스");

        Random rad = new Random();
        String pick = menus.get(rad.nextInt(menus.size()));

        model.addAttribute("pick", pick);
        return "lunch";
    }

    @GetMapping("/lotto")
    public String lotto(Model model){
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        List<Integer> lucky = numbers.subList(0, 6);

        model.addAttribute("lucky", lucky);

        return "lotto";
    }
}
