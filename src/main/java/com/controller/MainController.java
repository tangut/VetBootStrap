package com.controller;

import com.domain.Pet;
import com.domain.User;
import com.repos.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private PetRepo petRepo;

    @Value("${upload.path}")
    private String uploadPath;

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
    public String add(@AuthenticationPrincipal User user, @RequestParam String name, @RequestParam String kind,
                      @RequestParam String breed, Map<String, Object> model,  @RequestParam("file") MultipartFile file) throws IOException {
        Pet pet = new Pet(name, kind, breed, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            pet.setFilename(resultFilename);
        }

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
