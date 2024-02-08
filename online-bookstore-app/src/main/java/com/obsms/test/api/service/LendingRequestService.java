package com.obsms.test.api.service;

import com.obsms.test.api.commons.abs.data.AddonCRUDService;
import com.obsms.test.api.data.entity.LendingRequest;

public interface LendingRequestService extends AddonCRUDService<LendingRequest> {

    /**
     * @param trackingNumber
     * @return {@link LendingRequest}
     */
    LendingRequest findByTrackingNumber(String trackingNumber);
}
