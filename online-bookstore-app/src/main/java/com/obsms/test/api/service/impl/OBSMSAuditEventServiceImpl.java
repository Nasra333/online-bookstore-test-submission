package com.obsms.test.api.service.impl;

import com.obsms.test.api.data.entity.*;
import com.obsms.test.api.model.response.AuditSnapshotResponse;
import com.obsms.test.api.service.OBSMSAuditEventService;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "OBSMSAuditEventServiceImpl")
public class OBSMSAuditEventServiceImpl implements OBSMSAuditEventService {

    private final Javers javers;

    @Autowired
    public OBSMSAuditEventServiceImpl(Javers javers) {
        this.javers = javers;
    }

    @Override
    public ResponseEntity<AuditSnapshotResponse> getStoresSnapshots() {
        QueryBuilder jqlQuery = QueryBuilder
                .byClass(BookCategory.class, Book.class, LendingRequest.class,
                        LendingRecord.class, Users.class, UserBrowseHistory.class);
        List<CdoSnapshot> snapshots = javers.findSnapshots(jqlQuery.build());
        return ResponseEntity.ok(
                AuditSnapshotResponse
                        .builder()
                        .payload(javers.getJsonConverter().toJson(snapshots))
                        .build());
    }
}
