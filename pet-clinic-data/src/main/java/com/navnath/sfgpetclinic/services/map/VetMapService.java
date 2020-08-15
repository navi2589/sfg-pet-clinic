package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.Vet;
import com.navnath.sfgpetclinic.services.CurdService;

import java.util.Set;

public class VetMapService extends  AbstractMapService<Vet, Long> implements CurdService<Vet,Long> {

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
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
