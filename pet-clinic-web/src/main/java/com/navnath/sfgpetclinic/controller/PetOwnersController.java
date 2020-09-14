package com.navnath.sfgpetclinic.controller;

import com.navnath.sfgpetclinic.services.PetOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/petowners")
@Controller
public class PetOwnersController {

    private final PetOwnerService petOwnerService;

    public PetOwnersController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @RequestMapping({"/index"})
    String getPetOwnerList(Model model){
        model.addAttribute("petOwners", petOwnerService.findAll());
        return "petowners/index";
    }
}
