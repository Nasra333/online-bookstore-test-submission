package com.obsms.test.api.commons.endpoint;

import com.obsms.test.api.commons.abs.data.AbstractAddonPersistable;
import com.obsms.test.api.commons.abs.data.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public class AbstractPersistableEntityEndpoint<D extends AbstractAddonPersistable, S extends CRUDService<D>> {

    @Autowired
    protected S service;

    /**
     * @param entityId
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<D> selectById(String entityId) {
        return ok(getService().get(entityId));
    }

    /**
     * @param entityId
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<Void> delete(String entityId) {
        getService().delete(entityId);
        return ok(null);
    }

    /**
     * @param entity
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<D> update(D entity) {
        return ok().body(getService().update(entity));
    }

    /**
     * @return
     */
    public ResponseEntity<List<D>> getAll() {
        return ok(getService().getAll());
    }

    /**
     * @param entity
     * @return
     */
    public ResponseEntity<D> create(D entity) {
        return ok(getService().create(entity));
    }

    /**
     * @param entities
     * @return
     */
    public ResponseEntity<List<D>> create(List<D> entities) {
        return ok(getService().create(entities));
    }

    /**
     * @param entity
     */
    public void executePostHooksUpdate(D entity) {
    }

    /**
     * @param persistingEntity
     * @param persistendEntity
     */
    public void executePostHooksUpdate(D persistingEntity, D persistendEntity) {
    }

    /**
     * @param entity
     * @param partialUpdate
     * @return
     */
    public ResponseEntity<D> update(D entity, Boolean partialUpdate) {
        return ok(getService().update(entity, partialUpdate));
    }

    /**
     * @param entities
     * @return
     */
    public ResponseEntity<Collection<D>> update(Collection<D> entities) {
        return ok(getService().update(entities));
    }

    /**
     * @param entities
     * @param partialUpdate
     * @return
     */
    public ResponseEntity<Collection<D>> update(Collection<D> entities, Boolean partialUpdate) {
        return ok(getService().update(entities, partialUpdate));
    }

    /**
     * @param id
     * @return
     */
    public ResponseEntity<D> get(String id) {
        return ok(getService().get(id));
    }

    /**
     * @param entityId
     * @return
     */
    public ResponseEntity<D> getSilently(String entityId) {
        return ok(getService().getSilently(entityId));
    }

    /**
     * @param entityId
     * @param version
     * @return
     */
    public ResponseEntity<D> get(String entityId, String version) {
        return ok(getService().get(entityId, version));
    }

    /**
     * @return {@link S}
     */
    protected S getService() {
        return service;
    }
}