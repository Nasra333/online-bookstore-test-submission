package com.obsms.test.api.commons.abs.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @param <T>
 * @param <J>
 * @author Ikram Samaad.
 */
public abstract class AbstractCRUDService<T extends Persistable<String>, J extends JpaRepository<T, String>> implements CRUDService<T> {

    @Autowired
    protected J repository;

    @Override
    public T create(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public List<T> create(List<T> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    public void executePostHooksUpdate(T entity) {
    }

    @Override
    public void executePostHooksUpdate(T persistingEntity, T persistedEntity) {
    }

    @Override
    public T update(T entity) {
        //entity.setVersion(entity.getVersion() + 1);
        return repository.saveAndFlush(entity);
    }

    @Override
    public T update(T entity, Boolean partialUpdate) {
        //entity.setVersion(entity.getVersion() + 1);
        if (partialUpdate)
            return repository.save(entity);
        else
            return repository.saveAndFlush(entity);
    }

    @Override
    public Collection<T> update(Collection<T> entities) {
        //entities.stream().forEach(e -> e.setVersion(e.getVersion() + 1));
        return repository.saveAllAndFlush(entities);
    }

    @Override
    public Collection<T> update(Collection<T> entities, Boolean partialUpdate) {
        //entities.stream().forEach(e -> e.setVersion(e.getVersion() + 1));
        if (partialUpdate)
            return repository.saveAll(entities);
        else
            return repository.saveAllAndFlush(entities);
    }

    @Override
    public T get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public T getSilently(String entityId) {
        return repository.findById(entityId).orElse(null);
    }

    @Override
    public T get(String entityId, String version) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }
}
