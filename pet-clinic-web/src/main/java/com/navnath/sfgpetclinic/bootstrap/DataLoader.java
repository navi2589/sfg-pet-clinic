package com.navnath.sfgpetclinic.bootstrap;

import com.navnath.sfgpetclinic.model.*;
import com.navnath.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetOwnerService petOwnerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(PetOwnerService petOwnerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.petOwnerService = petOwnerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        cat.setName("Cat");
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

        PetOwner navnath = new PetOwner();
        navnath.setFirstName("Navnath");
        navnath.setLastName("Chincore");
        navnath.setAddress("Loha");
        navnath.setCity("Loha");
        navnath.setTelephone("908080880");
        Pet navnathPet = new Pet();
        navnathPet.setName("Navi");
        navnathPet.setPetType(savedDogPetType);
        navnathPet.setBirthDate(LocalDate.now());
        navnath.getPets().add(navnathPet);
        navnathPet.setPetOwner(navnath);
        petOwnerService.save(navnath);


        PetOwner subhash = new PetOwner();
        subhash.setFirstName("Subhash");
        subhash.setLastName("Chincore");
        subhash.setAddress("Nanded");
        subhash.setCity("Loha");
        subhash.setTelephone("8087557408");

        Pet subhashPet = new Pet();
        subhashPet.setName("Navi");
        subhashPet.setPetType(savedCatPetType);
        subhashPet.setBirthDate(LocalDate.now());
        subhashPet.setPetOwner(subhash);
        subhash.getPets().add(subhashPet);
        petOwnerService.save(subhash);

        Visit subhashPetVisit = new Visit();
        subhashPetVisit.setPet(subhashPet);
        subhashPetVisit.setDescription("Snizzy cat");
        subhashPetVisit.setVisitDate(LocalDate.now());
        visitService.save(subhashPetVisit);



        System.out.println("..... petowner  Loaded");

        Vet raviVet = new Vet();
        raviVet.setFirstName("Ravi");
        raviVet.setLastName("Chinchore");
        raviVet.getSpecialities().addAll(new HashSet<>(Arrays.asList(savedDentistry, savedMedicine,savedRediology)));
        vetService.save(raviVet);

        Vet sunilVet = new Vet();
        sunilVet.setFirstName("Sunil");
        sunilVet.setLastName("Chinchore");
        sunilVet.getSpecialities().addAll(new HashSet<>(Arrays.asList(savedDentistry, savedMedicine,savedRediology)));
        vetService.save(sunilVet);

        System.out.println("..... Vet Loaded");
    }
}
