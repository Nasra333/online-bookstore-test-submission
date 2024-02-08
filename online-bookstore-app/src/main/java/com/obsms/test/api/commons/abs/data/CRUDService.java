package com.obsms.test.api.commons.abs.data;

import java.util.Collection;
import java.util.List;

/**
 *
 * @param <T>
 */
public interface CRUDService<T extends Persistable<String>> {

    T create(T entity);

    List<T> create(List<T> entities);

    void executePostHooksUpdate(T entity);

    void executePostHooksUpdate(T persistingEntity, T persistendEntity);

    T update(T entity);

    T update(T entity, Boolean partialUpdate);

    Collection<T> update(Collection<T> entities);

    Collection<T> update(Collection<T> entities, Boolean partialUpdate);

    T get(String id);

    void delete(String id);

    // Retrieves entity but does not fail if it does not exist
    T getSilently(String entityId);

    T get(String entityId, String version);

    List<T> getAll();

}
