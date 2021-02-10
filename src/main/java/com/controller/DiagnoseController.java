package com.controller;

import com.domain.Diagnose;
import com.domain.Pet;
import com.repos.DiagnoseRepo;
import com.repos.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
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
        dia.setSimptome("no simptom");
        dia.setMedicine("no medicine");
        dia.setPet(pets.get(0));
        List<Diagnose> dias = new ArrayList<>();
        diagnoseRepo.save(dia);
        dias.add(dia);
        model.addAttribute("pets", pets);
        model.addAttribute("diagnoses", dias);
        return "redirect:/pet/" + petId.toString() + "/diagnose/" + dia.getId();
    }

    @GetMapping("pet/{id}/diagnose/{did}")
    public String getDiagnose(@PathVariable String id, @PathVariable String did, Model model){
        Integer diaId = Integer.valueOf(did);
        Integer petId = Integer.valueOf(id);
        List<Pet> pets = petRepo.findById(petId);
        List<Diagnose> diagnoses = diagnoseRepo.findById(diaId);
        model.addAttribute("pets", pets);
        model.addAttribute("diagnoses", diagnoses);
        return "diagnoseEdit";
    }

    @PostMapping("pet/{id}/diagnose/{did}")
    public String diagnoseEdit(@PathVariable String did, @RequestParam String name,
                               @RequestParam String simptom, @RequestParam String medicine){
        Integer diaId = Integer.valueOf(did);
        List<Diagnose> dias = diagnoseRepo.findById(diaId);
        Diagnose diagnose = dias.get(0);
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(simptom) && !StringUtils.isEmpty(medicine)){
            diagnose.setSimptome(simptom);
            diagnose.setMedicine(medicine);
            diagnose.setName(name);
        }
        diagnoseRepo.save(diagnose);
        return "redirect:/diagnoseEdit";
    }
}
