package com.navnath.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetOwnersController {
    @RequestMapping({"/petowners"})
    String getPetOwnerList(){
        return "petowners/index";
    }
}
