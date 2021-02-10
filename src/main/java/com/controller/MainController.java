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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private PetRepo petRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greetings";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model, @AuthenticationPrincipal User user) {
        Iterable<Pet> pets = petRepo.findAll();
        Set<Pet> userPets = new HashSet<>();
        for (Pet pet:pets){
            if (pet.getMaster().getUsername().equals(user.getUsername())){
                userPets.add(pet);
            }
        }

        model.addAttribute("pets", userPets);
        return "main";
    }


    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String name, @RequestParam String kind, @RequestParam String breed, Map<String, Object> model) {
        Pet pet = new Pet(name, kind, breed, user);

        petRepo.save(pet);

        Iterable<Pet> pets = petRepo.findAll();
        Set<Pet> userPets = new HashSet<>();
        for (Pet allPet:pets){
            if (allPet.getMaster().getUsername().equals(user.getUsername())){
                userPets.add(allPet);
            }
        }

        model.put("pets", userPets);

        return "main";
    }

}
