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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DiagnoseController {
    @Autowired
    DiagnoseRepo diagnoseRepo;
    @Autowired
    PetRepo petRepo;

    @GetMapping("pet/{id}/diagnose")
    public String getDiagnose(@PathVariable String id, Model model){
        Integer petId = Integer.valueOf(id);
        List<Pet> pets = petRepo.findById(petId);
        Diagnose dia = new Diagnose();
        dia.setName("no name");
        dia.setSimptome("no simptome");
        dia.setMedicine("no medicine");
        dia.setPet(pets.get(0));
        List<Diagnose> dias = new ArrayList<>();
        dias.add(dia);
        model.addAttribute("pets", pets);
        model.addAttribute("diagnoses", dias);
        return "diagnoseEdit";
    }

    @GetMapping("pet/{id}/diagnose/{did}")
    public String getDiagnose(@PathVariable String id, @PathVariable String did, Model model){
        Long diaId = Long.valueOf(did);
        Integer petId = Integer.valueOf(id);
        List<Pet> pets = petRepo.findById(petId);
        Optional<Diagnose> diagnoses = diagnoseRepo.findById(diaId);
        model.addAttribute("pets", pets);
        model.addAttribute("diagnoses", diagnoses);
        return "diagnoseEdit";
    }

}
