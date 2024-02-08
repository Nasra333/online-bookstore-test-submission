package com.obsms.test.api.commons.abs.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Ikram Samaad.
 */
@MappedSuperclass
public abstract class AbstractAddonPersistable extends AbstractPersistable<String> {

    private static final long serialVersionUID = 1L;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNewEntity() {
        return version == 0;
    }
}
