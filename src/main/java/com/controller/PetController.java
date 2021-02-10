package com.controller;

import com.domain.Diagnose;
import com.domain.Pet;
import com.repos.DiagnoseRepo;
import com.repos.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetRepo petRepo;

    @Autowired
    DiagnoseRepo diagnoseRepo;

    @GetMapping("{id}")
    public String getInfo(@PathVariable String id, Model model){
        Integer intID = Integer.valueOf(id);
        List<Pet> pet = petRepo.findById(intID);
        List<Diagnose> diagnoses = diagnoseRepo.findByPet(pet);
        model.addAttribute("pets", pet);
        model.addAttribute("diagnoses", diagnoses);

        return "pet";
    }

}
