package com.navnath.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping("/vets")
    String getVetList(){
        return "vets/index.html";
    }
}
