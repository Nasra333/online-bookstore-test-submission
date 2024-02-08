package com.obsms.test.api.commons.abs.data;

import java.util.List;

public abstract class AbstractActiveCRUDService<T extends Persistable<String>, J extends AddonActiveEntityJpaRepository<T>> extends AbstractAddonCRUDService<T, J> implements AddonCRUDService<T> {

    public List<T> getAllByActivated() {
        return repository.getAllByActivated();
    }

    @Override
    public List<T> getAllByDeactivated() {
        return repository.getAllByDeactivated();
    }

    @Override
    public void activate(String id) {
        repository.activate(id);
    }

    @Override
    public void deactivate(String id) {
        repository.deactivate(id);
    }
}
