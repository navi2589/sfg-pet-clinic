package com.navnath.sfgpetclinic.services.map;

import com.navnath.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    Map<Long, T> map = new HashMap<>();

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    protected T findById(ID id) {
        return map.get(id);
    }

    protected T save(T object) {
        if (Objects.nonNull(object)) {
            if (Objects.isNull(object.getId())) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }

    protected void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    protected void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        if (map.isEmpty()) {
            return 1L;
        } else {
            return Collections.max(map.keySet()) + 1;
        }
    }
}
