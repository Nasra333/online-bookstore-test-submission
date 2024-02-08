package com.obsms.test.api.commons.service;


import com.obsms.test.api.commons.abs.data.CRUDService;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;

public interface RepositoryAuditUserService extends CRUDService<RepositoryAuditUser> {

    /**
     * @return {@link RepositoryAuditUser}
     */
    RepositoryAuditUser getSystemAuditUser();

    /**
     *
     * @param auditorName
     * @return {@link RepositoryAuditUser}
     */
    RepositoryAuditUser getAuditUserByName(String auditorName);
}
