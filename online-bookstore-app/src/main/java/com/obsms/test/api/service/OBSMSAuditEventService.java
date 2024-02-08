    package com.obsms.test.api.service;

import com.obsms.test.api.model.response.AuditSnapshotResponse;
import org.springframework.http.ResponseEntity;

public interface OBSMSAuditEventService {

    /**
     * @return {@link ResponseEntity}
     */
    ResponseEntity<AuditSnapshotResponse> getStoresSnapshots();
}