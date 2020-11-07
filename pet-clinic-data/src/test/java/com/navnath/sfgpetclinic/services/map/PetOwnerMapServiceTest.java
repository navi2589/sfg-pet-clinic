package com.navnath.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PetOwnerMapServiceTest {

    PetOwnerMapService petOwnerMapService;
    long PET_OWNER_ID = 1L;
    String PET_OWNER_LAST_NAME = "navnath";

    @BeforeEach
    void setUp() {
        petOwnerMapService = new PetOwnerMapService(new PetTypeMapService(), new PetMapService());
        petOwnerMapService.save(PetOwner.builder().id(PET_OWNER_ID).lastName("navnath").build());
    }

    @Test
    void findAll() {
       int size =  petOwnerMapService.findAll().size();
       assertEquals(size,1);
    }

    @Test
    void deleteById() {
        petOwnerMapService.deleteById(PET_OWNER_ID);
        int size =  petOwnerMapService.findAll().size();
        assertEquals(size,0);
    }

    @Test
    void delete() {
        PetOwner petowner = petOwnerMapService.findById(PET_OWNER_ID);
        petOwnerMapService.delete(petowner);
        int size =  petOwnerMapService.findAll().size();
        assertEquals(size,0);
    }

    @Test
    void save() {
        PetOwner petowner =  PetOwner.builder().id(2L).build();
        petowner = petOwnerMapService.save(petowner);
        int size =  petOwnerMapService.findAll().size();
        assertEquals(size,2);
    }

    @Test
    void saveWithOutExistingId() {
        PetOwner petowner =  PetOwner.builder().id(2L).build();
        petowner = petOwnerMapService.save(petowner);
        int size =  petOwnerMapService.findAll().size();
        assertEquals(size,2);
        assertEquals(petowner.getId(),2L);
    }

    @Test
    void saveWithExistingId() {
        PetOwner petowner =  petOwnerMapService.findById(PET_OWNER_ID);
        petowner = petOwnerMapService.save(petowner);
        int size =  petOwnerMapService.findAll().size();
        assertEquals(petowner.getId(),PET_OWNER_ID);
    }

    @Test
    void findById() {
        PetOwner petowner = petOwnerMapService.findById(PET_OWNER_ID);
        assertEquals(petowner.getId(),PET_OWNER_ID);
    }
    @Test
    void findByLatName() {
        PetOwner petowner = petOwnerMapService.findByLastName(PET_OWNER_LAST_NAME);
        assertNotNull(petowner);
        assertEquals(petowner.getLastName(),PET_OWNER_LAST_NAME);
    }
}