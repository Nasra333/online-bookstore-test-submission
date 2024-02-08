package com.obsms.test.api.commons.endpoint.impl;

import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.endpoint.AbstractPersistableEntityEndpoint;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ikram Samaad.
 */
@RestController
@CrossOrigin
@RequestMapping(
        value = {"/repositoryAuditUser"},
        consumes = {"application/json"},
        produces = {"application/json"})
@Transactional
@Primary
public class RepositoryAuditUserEndpoint
        extends AbstractPersistableEntityEndpoint<RepositoryAuditUser, RepositoryAuditUserService> {

    @RequestMapping(
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    @Override
    public ResponseEntity<RepositoryAuditUser> create(@RequestBody RepositoryAuditUser entity) {
        return super.create(entity);
    }

    @RequestMapping(
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.PUT}
    )
    @Override
    public ResponseEntity<RepositoryAuditUser> update(@RequestBody RepositoryAuditUser entity) {
        return super.update(entity);
    }

    @RequestMapping(
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    @Override
    public ResponseEntity<List<RepositoryAuditUser>> getAll() {
        return super.getAll();
    }
}
