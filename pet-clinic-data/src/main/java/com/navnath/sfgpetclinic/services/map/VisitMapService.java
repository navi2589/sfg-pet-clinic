package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.Visit;
import com.navnath.sfgpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends  AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() ==null
        || visit.getPet().getPetOwner() == null || visit.getPet().getPetOwner().getId() == null){
            throw  new RuntimeException("Invalid visit entity");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
