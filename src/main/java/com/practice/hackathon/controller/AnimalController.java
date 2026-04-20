package com.practice.hackathon.controller;

import com.practice.hackathon.model.Animal;
import com.practice.hackathon.service.AnimalService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService, ServletContext servletContext) {
        this.animalService = animalService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(@RequestParam(value = "keyword", required = false) String keyword,
                       Model model) {
        model.addAttribute("animals", animalService.getAllAnimal(keyword));
        return "list";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("animal", new Animal());
        return "form";
    }

    @PostMapping("/save")
    public String add(
            @Valid @ModelAttribute("animal") Animal animal,
            BindingResult bindingResult,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam("file") MultipartFile file
    ) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Animal course = animalService.getAnimalById(id);
        model.addAttribute("course", course);
        model.addAttribute("courseId", id);
        return "form";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        animalService.removeAnimal(id);
        return "redirect:/list";
    }


}
