package com.navnath.sfgpetclinic.services;

import com.navnath.sfgpetclinic.model.PetOwner;

import java.util.Set;

public interface PetOwnerService extends CurdService<PetOwner,Long> {

    PetOwner findByLastName(String lastname);
}
