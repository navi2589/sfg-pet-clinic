package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.PetOwner;
import com.navnath.sfgpetclinic.services.CurdService;

import java.util.Set;

public class PetOwnerMapService extends AbstractMapService<PetOwner,Long> implements CurdService<PetOwner,Long> {
    @Override
    public Set<PetOwner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetOwner object) {
        super.delete(object);
    }

    @Override
    public PetOwner save(PetOwner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public PetOwner findById(Long id) {
        return super.findById(id);
    }
}
