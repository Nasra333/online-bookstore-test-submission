
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AbstractPersistable;
import com.obsms.test.api.commons.abs.data.AddonAuditableJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author walles
 */

@Repository
public interface PersistableRepository extends AddonAuditableJpaRepository<AbstractPersistable<String>> {
}
