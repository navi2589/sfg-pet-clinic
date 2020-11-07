package com.navnath.sfgpetclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.services.PetOwnerService;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class PetOwnersControllerTest {
    @Mock
    PetOwnerService petOwnerService;
    @InjectMocks
    PetOwnersController petOwnersController;
    Set<PetOwner> ownerSet;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerSet = new HashSet<>();
        ownerSet.add(PetOwner.builder().id(1L).build());
        ownerSet.add(PetOwner.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(petOwnersController)
                .build();
    }

    @Test
    void getPetOwnerList() throws Exception {
        when(petOwnerService.findAll()).thenReturn(ownerSet);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("petowners/index"))
                .andExpect(model().attribute("petOwners", hasSize(2)));


    }

    @Test
    void findPetOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplementedYet"));
    }
}