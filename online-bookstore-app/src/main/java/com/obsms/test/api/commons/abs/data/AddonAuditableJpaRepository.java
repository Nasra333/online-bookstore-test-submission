package com.obsms.test.api.commons.abs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AddonAuditableJpaRepository<T> extends JpaRepository<T, String> {
}
