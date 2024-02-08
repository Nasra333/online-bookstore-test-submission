package com.obsms.test.api.data.repository;

import org.hibernate.Session;
import javax.persistence.EntityManager;

public interface CustomOBSMSJpaRepository<T> {

    /**
     *
     * @return {@link EntityManager}
     */
    EntityManager getEm();

    /**
     *
     * @return {@link Session}
     */
    Session getSession();

    T save(T entity);
}
