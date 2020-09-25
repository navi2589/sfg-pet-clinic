package com.navnath.sfgpetclinic.bootstrap;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.model.PetType;
import com.navnath.sfgpetclinic.model.Vet;
import com.navnath.sfgpetclinic.services.PetOwnerService;
import com.navnath.sfgpetclinic.services.PetTypeService;
import com.navnath.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetOwnerService petOwnerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(PetOwnerService petOwnerService, VetService vetService, PetTypeService petTypeService) {
        this.petOwnerService = petOwnerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);

        PetOwner petOwner1 = new PetOwner();
        petOwner1.setFirstName("Navnath");
        petOwner1.setLastName("Chincore");
        petOwnerService.save(petOwner1);


        PetOwner petOwner2 = new PetOwner();
        petOwner2.setFirstName("Subhash");
        petOwner2.setLastName("Chincore");
        petOwnerService.save(petOwner2);
        System.out.println("..... petowner  Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ravi");
        vet1.setLastName("Chinchore");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sunil");
        vet2.setLastName("Chinchore");
        vetService.save(vet2);

        System.out.println("..... Vet Loaded");


    }
}
