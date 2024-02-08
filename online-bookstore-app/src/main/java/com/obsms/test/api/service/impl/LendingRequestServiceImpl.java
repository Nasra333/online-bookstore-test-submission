package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.LendingRequest;
import com.obsms.test.api.data.repository.LendingRequestRepository;
import com.obsms.test.api.service.LendingRequestService;
import org.springframework.stereotype.Service;

@Service
public class LendingRequestServiceImpl
        extends AbstractActiveCRUDService<LendingRequest, LendingRequestRepository>
        implements LendingRequestService {

    @Override
    public LendingRequest findByTrackingNumber(String trackingNumber) {
        return repository.findByTrackingNumber(trackingNumber);
    }
}
