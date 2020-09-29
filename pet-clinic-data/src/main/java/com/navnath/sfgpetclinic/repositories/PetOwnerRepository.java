package com.navnath.sfgpetclinic.repositories;

import com.navnath.sfgpetclinic.model.PetOwner;
import org.springframework.data.repository.CrudRepository;

public interface PetOwnerRepository extends CrudRepository<PetOwner, Long> {
    PetOwner findByLastName(String lastName);
}
