package com.navnath.sfgpetclinic.services;

import com.navnath.sfgpetclinic.model.PetOwner;

import java.util.Set;

public interface PetOwnerService {

    PetOwner findByLastName(String lastname);
    PetOwner findById(Long id);
    PetOwner save(PetOwner petOwner);
    Set<PetOwner> findAll();
}
