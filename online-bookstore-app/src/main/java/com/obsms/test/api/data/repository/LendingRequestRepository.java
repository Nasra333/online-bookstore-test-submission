
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonActiveEntityJpaRepository;
import com.obsms.test.api.data.entity.LendingRequest;
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
public interface LendingRequestRepository extends AddonActiveEntityJpaRepository<LendingRequest> {

    @Query(value = "SELECT l FROM LendingRequest l WHERE l.trackingNumber = :trackingNumber")
    public LendingRequest findByTrackingNumber(@Param(value = "trackingNumber") String trackingNumber);

    @Query(value = "SELECT l FROM LendingRequest l WHERE l.active = true")
    @Override
    public List<LendingRequest> getAllByActivated();
    
    @Query(value = "SELECT l FROM LendingRequest l WHERE l.active = false")
    @Override
    public List<LendingRequest> getAllByDeactivated();

    @Modifying
    @Query(value = "UPDATE LendingRequest l SET l.active = true WHERE l.id = :id")
    @Override
    public void activate(@Param(value = "id") String id);

    @Modifying
    @Query(value = "UPDATE LendingRequest l SET l.active = false WHERE l.id = :id")
    @Override
    public void deactivate(@Param(value = "id") String id);
}
