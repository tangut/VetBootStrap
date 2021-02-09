package com.controller;

import com.domain.User;
import com.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping()
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", userRepo.findByUsername(user.getUsername()));
        return "profile";
    }

    @PostMapping()
    public String updateProfile(@AuthenticationPrincipal User user, @RequestParam String password){

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        userRepo.save(user);

        return "redirect:/profile";
    }
}
