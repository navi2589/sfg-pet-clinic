package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.Pet;
import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.services.CurdService;
import com.navnath.sfgpetclinic.services.PetOwnerService;
import com.navnath.sfgpetclinic.services.PetService;
import com.navnath.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default","map"})
public class PetOwnerMapService extends AbstractMapService<PetOwner, Long> implements PetOwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public PetOwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<PetOwner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetOwner object)
    {
        super.delete(object);
    }

    @Override
    public PetOwner save(PetOwner object)
    {
        if(Objects.nonNull(object)){
            if(Objects.nonNull(object.getPets())){
                object.getPets().forEach(pet->{
                    if(Objects.nonNull(pet.getPetType())){
                        if(Objects.isNull(pet.getPetType().getId())){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw  new RuntimeException("Pettype is required.");
                    }
                    if(Objects.isNull(pet.getId())){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public PetOwner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetOwner findByLastName(String lastname) {
        return super.findAll().stream().filter(petOwner -> lastname.equalsIgnoreCase(petOwner.getLastName())).findAny().orElse(null);
    }
}
