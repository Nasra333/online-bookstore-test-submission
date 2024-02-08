package com.obsms.test.api.commons.data.repository;

import com.obsms.test.api.commons.abs.data.AddonAuditableJpaRepository;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAuditUserRepository extends AddonAuditableJpaRepository<RepositoryAuditUser> {

    /**
     * @return {@link RepositoryAuditUser}
     */
    @Query(value = "SELECT r FROM RepositoryAuditUser r WHERE r.auditorName = 'System'")
    public RepositoryAuditUser getSystemAuditUser();

    /**
     * @param auditorName
     * @return {@link RepositoryAuditUser}
     */
    @Query(value = "SELECT r FROM RepositoryAuditUser r WHERE r.auditorName = :auditorName ")
    public RepositoryAuditUser getAuditUserByName(@Param(value = "auditorName") String auditorName);
}
