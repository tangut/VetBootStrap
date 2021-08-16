package com.controller;

import com.domain.Pet;
import com.domain.User;
import com.repos.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AllPetController {
    @Autowired
    PetRepo petRepo;

    @GetMapping("/petList")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Pet> pets = petRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            pets = petRepo.findById(Integer.valueOf(filter));
        } else {
            pets = petRepo.findAll();
        }


        model.addAttribute("pets", pets);
        model.addAttribute("filter", filter);

        return "petList";
    }


    @PostMapping("/petList")
    public String add(@AuthenticationPrincipal User user, @RequestParam String name, @RequestParam String kind, @RequestParam String breed, Map<String, Object> model) {
        Pet pet = new Pet(name, kind, breed, user);

        petRepo.save(pet);

        Iterable<Pet> pets = petRepo.findAll();

        model.put("pets", pets);

        return "petList";
    }
}
