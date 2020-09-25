package com.navnath.sfgpetclinic.bootstrap;

import com.navnath.sfgpetclinic.model.*;
import com.navnath.sfgpetclinic.services.PetOwnerService;
import com.navnath.sfgpetclinic.services.PetTypeService;
import com.navnath.sfgpetclinic.services.SpecialityService;
import com.navnath.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetOwnerService petOwnerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(PetOwnerService petOwnerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.petOwnerService = petOwnerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality rediology =  new Speciality();
        rediology.setDescription("Rediology");
        Speciality savedRediology = specialityService.save(rediology);

        Speciality medicine =  new Speciality();
        medicine.setDescription("Medicine");
        Speciality savedMedicine = specialityService.save(medicine);

        Speciality dentistry =  new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        PetOwner petOwner1 = new PetOwner();
        petOwner1.setFirstName("Navnath");
        petOwner1.setLastName("Chincore");
        petOwner1.setAddress("Loha");
        petOwner1.setCity("Loha");
        petOwner1.setTelephone("908080880");
        Pet navnathPet = new Pet();
        navnathPet.setName("Navi");
        navnathPet.setPetType(savedDogPetType);
        navnathPet.setBirthDate(LocalDate.now());
        petOwner1.getPets().add(navnathPet);
        petOwnerService.save(petOwner1);


        PetOwner petOwner2 = new PetOwner();
        petOwner2.setFirstName("Subhash");
        petOwner2.setLastName("Chincore");
        petOwner1.setAddress("Nanded");
        petOwner1.setCity("Loha");
        petOwner1.setTelephone("8087557408");
        Pet subhashPet = new Pet();
        subhashPet.setName("Navi");
        subhashPet.setPetType(savedCatPetType);
        subhashPet.setBirthDate(LocalDate.now());
        petOwner2.getPets().add(subhashPet);
        petOwnerService.save(petOwner2);
        System.out.println("..... petowner  Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ravi");
        vet1.setLastName("Chinchore");
        vet1.getSpecialities().addAll(new HashSet<>(Arrays.asList(savedDentistry, savedMedicine,savedRediology)));
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sunil");
        vet2.setLastName("Chinchore");
        vet2.getSpecialities().addAll(new HashSet<>(Arrays.asList(savedDentistry, savedMedicine,savedRediology)));
        vetService.save(vet2);

        System.out.println("..... Vet Loaded");
    }
}
