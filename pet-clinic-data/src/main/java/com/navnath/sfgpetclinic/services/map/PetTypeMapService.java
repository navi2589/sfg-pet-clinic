package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.PetType;
import com.navnath.sfgpetclinic.services.CurdService;
import com.navnath.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}