package com.obsms.test.api.commons.endpoint;

import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.abs.data.AddonCRUDService;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public abstract class AbstractActiveAuditableEntityEndpoint<D extends AbstractActiveAuditable, S extends AddonCRUDService<D>> extends AbstractAuditableEntityEndpoint<D, S> {

    @Override
    public ResponseEntity<List<D>> getAll() {
        List<D> list = new ArrayList<>();
        list.addAll(getService().getAllByActivated());
        return ResponseEntity.ok(list);
    }

    /**
     * @return
     */
    public ResponseEntity<List<D>> getAllByActivated() {
        return ok(getService().getAllByActivated());
    }

    /**
     * @return
     */
    public ResponseEntity<List<D>> getAllByDeactivated() {
        return ok(getService().getAllByDeactivated());
    }

    /**
     * @param id The Id of SourceAccount
     * @return
     */
    public ResponseEntity<Void> activate(String id) {
        getService().activate(id);
        return ok().build();
    }

    /**
     * @param id The Id of SourceAccount
     * @return
     */
    public ResponseEntity<Void> deactivate(String id) {
        getService().deactivate(id);
        return ok().build();
    }
}
