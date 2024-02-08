package com.obsms.test.api.commons.abs.data;

import java.util.Date;

public interface Auditable<U, PK, T extends Date> extends Persistable<PK> {

    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    U getCreatedBy();

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    void setCreatedBy(U createdBy);

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    T getCreatedDate();

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date to set
     */
    void setCreatedDate(T creationDate);

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    U getLastModifiedBy();

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    void setLastModifiedBy(U lastModifiedBy);

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    T getLastModifiedDate();

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    void setLastModifiedDate(T lastModifiedDate);
}
