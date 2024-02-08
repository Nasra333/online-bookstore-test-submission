package com.obsms.test.api.commons.abs.data;

import java.io.Serializable;
import java.util.List;

public interface AddonCRUDService<T extends Persistable<String>> extends CRUDService<T>, Serializable {

    /**
     * @param id The Id of SourceAccount
     * @return
     */
    void activate(String id);

    /**
     * @param id The Id of SourceAccount
     * @return
     */
    public void deactivate(String id);

    /**
     * @return {@link List}
     */
    List<T> getAllByActivated();

    /**
     * @return {@link List}
     */
    List<T> getAllByDeactivated();
}
