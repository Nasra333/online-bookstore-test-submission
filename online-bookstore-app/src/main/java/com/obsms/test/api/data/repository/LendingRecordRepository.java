
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonActiveEntityJpaRepository;
import com.obsms.test.api.data.entity.LendingRecord;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ope
 */
@JaversSpringDataAuditable
@Repository
public interface LendingRecordRepository extends AddonActiveEntityJpaRepository<LendingRecord> {

    @Query(value = "SELECT l FROM LendingRecord l WHERE l.active = true")
    @Override
    public List<LendingRecord> getAllByActivated();

    @Query(value = "SELECT l FROM LendingRecord l WHERE l.active = false")
    @Override
    public List<LendingRecord> getAllByDeactivated();

    @Modifying
    @Query(value = "UPDATE LendingRecord l SET l.active = true WHERE l.id = :id")
    @Override
    public void activate(@Param(value = "id") String id);

    @Modifying
    @Query(value = "UPDATE LendingRecord l SET l.active = false WHERE l.id = :id")
    @Override
    public void deactivate(@Param(value = "id") String id);
}
