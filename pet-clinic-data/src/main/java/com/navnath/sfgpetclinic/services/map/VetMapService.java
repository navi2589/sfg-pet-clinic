package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.Vet;
import com.navnath.sfgpetclinic.services.CurdService;
import com.navnath.sfgpetclinic.services.SpecialityService;
import com.navnath.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(Objects.nonNull(object)){
            if(Objects.nonNull(object.getSpecialities())){
                object.getSpecialities().forEach(speciality -> {
                    if(Objects.isNull(speciality.getId())){
                        object.getSpecialities().add(specialityService.save(speciality));
                    }
                });
            } else{
                throw new RuntimeException("Vet Speciality required..!!");
            }
            return super.save(object);
        } else {
            return  null;
        }

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
