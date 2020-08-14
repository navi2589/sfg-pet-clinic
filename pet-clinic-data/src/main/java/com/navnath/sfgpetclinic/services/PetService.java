package com.navnath.sfgpetclinic.services;

import com.navnath.sfgpetclinic.model.Pet;
import com.navnath.sfgpetclinic.model.PetOwner;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
