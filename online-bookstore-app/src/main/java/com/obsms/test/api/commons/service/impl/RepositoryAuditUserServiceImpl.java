package com.obsms.test.api.commons.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractAddonCRUDService;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.data.repository.RepositoryAuditUserRepository;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import org.springframework.stereotype.Service;

/**
 * @author Ikram Samaad.
 */
@Service
public class RepositoryAuditUserServiceImpl
        extends AbstractAddonCRUDService<RepositoryAuditUser, RepositoryAuditUserRepository>
        implements RepositoryAuditUserService {

    @Override
    public RepositoryAuditUser getSystemAuditUser() {
        return repository.getSystemAuditUser();
    }

    @Override
    public RepositoryAuditUser getAuditUserByName(String auditorName) {
        return repository.getAuditUserByName(auditorName);
    }
}
