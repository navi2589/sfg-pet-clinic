package com.navnath.sfgpetclinic.repositories;

import com.navnath.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
