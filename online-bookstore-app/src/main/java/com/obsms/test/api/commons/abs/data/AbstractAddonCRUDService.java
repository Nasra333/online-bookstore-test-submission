package com.obsms.test.api.commons.abs.data;


public abstract class AbstractAddonCRUDService<T extends Persistable<String>, J extends AddonAuditableJpaRepository<T>> extends AbstractCRUDService<T, J> implements CRUDService<T> {
}
