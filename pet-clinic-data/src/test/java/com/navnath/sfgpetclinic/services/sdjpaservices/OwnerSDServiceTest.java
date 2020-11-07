package com.navnath.sfgpetclinic.services.sdjpaservices;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.repositories.PetOwnerRepository;
import com.navnath.sfgpetclinic.repositories.PetRepository;
import com.navnath.sfgpetclinic.repositories.PetTypeRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSDServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final long ID = 1L;
    @Mock
    PetOwnerRepository petOwnerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDService petOwnerService;

    PetOwner smith;
    @BeforeEach
    void setUp() {
        smith = PetOwner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(petOwnerRepository.findByLastName(any())).thenReturn(smith);
        PetOwner petOwner = petOwnerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, petOwner.getLastName());
        verify(petOwnerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<PetOwner> owners = new HashSet<PetOwner>();
        owners.add(smith);
        when(petOwnerRepository.findAll()).thenReturn(owners);
        Set<PetOwner> petOwner = petOwnerService.findAll();
        assertEquals(petOwner.size(), owners.size());
        verify(petOwnerRepository).findAll();
    }

    @Test
    void findById() {
        when(petOwnerRepository.findById(any())).thenReturn(Optional.of(smith));
        PetOwner petOwner = petOwnerService.findById(ID);
        assertEquals(ID, petOwner.getId());
        verify(petOwnerRepository).findById(anyLong());
    }

    @Test
    void save() {
        PetOwner ownerToSave = PetOwner.builder().id(ID).lastName(LAST_NAME).build();
        when(petOwnerRepository.save(any())).thenReturn(smith);
        PetOwner savedOwner = petOwnerService.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        petOwnerService.delete(smith);
        verify(petOwnerRepository).delete(any());
    }

    @Test
    void deleteById() {
        petOwnerService.deleteById(ID);
        verify(petOwnerRepository).deleteById(anyLong());
    }
}