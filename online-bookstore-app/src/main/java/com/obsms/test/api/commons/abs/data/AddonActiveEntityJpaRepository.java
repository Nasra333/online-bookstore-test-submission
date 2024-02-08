package com.obsms.test.api.commons.abs.data;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AddonActiveEntityJpaRepository<T> extends AddonAuditableJpaRepository<T> {

    /**
     * @return {@link List}
     */
    List<T> getAllByActivated();

    /**
     * @return {@link List}
     */
    List<T> getAllByDeactivated();

    /**
     * @param id
     */
    void activate(String id);

    /**
     * @param id
     */
    void deactivate(String id);

}
