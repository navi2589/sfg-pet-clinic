package com.navnath.sfgpetclinic.services.sdjpaservices;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.repositories.PetOwnerRepository;
import com.navnath.sfgpetclinic.repositories.PetRepository;
import com.navnath.sfgpetclinic.repositories.PetTypeRepository;
import com.navnath.sfgpetclinic.services.PetOwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDService implements PetOwnerService {
    private final PetOwnerRepository petOwnerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDService(PetOwnerRepository petOwnerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.petOwnerRepository = petOwnerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public PetOwner findByLastName(String lastname) {
        return petOwnerRepository.findByLastName(lastname);
    }

    @Override
    public Set<PetOwner> findAll() {
        Set<PetOwner> petOwners = new HashSet<>();
        petOwnerRepository.findAll().forEach(petOwners::add);
        return petOwners;
    }

    @Override
    public PetOwner findById(Long id) {
        Optional<PetOwner> petOwnerOptional = petOwnerRepository.findById(id);
        PetOwner petOwner = null;
        if(petOwnerOptional.isPresent()){
            petOwner = petOwnerOptional.get();
        }
        return petOwner;
    }

    @Override
    public PetOwner save(PetOwner object) {
        return petOwnerRepository.save(object);
    }

    @Override
    public void delete(PetOwner object) {
        petOwnerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petOwnerRepository.deleteById(id);
    }
}
