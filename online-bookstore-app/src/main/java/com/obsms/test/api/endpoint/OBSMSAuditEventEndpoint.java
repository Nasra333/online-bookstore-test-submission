/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obsms.test.api.endpoint;

import com.obsms.test.api.model.response.AuditSnapshotResponse;
import com.obsms.test.api.service.OBSMSAuditEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ope
 */
@RestController
@CrossOrigin
@RequestMapping(value = {"/api/v1"}, produces = {"application/json"})
@Api(value = "Test Online Bookstore Service Api Audit", protocols = "http, https")
@Primary
public class OBSMSAuditEventEndpoint implements OBSMSAuditEventService {

    @Autowired
    @Qualifier(value = "OBSMSAuditEventServiceImpl")
    private OBSMSAuditEventService auditEventService;

    @ApiOperation(value = "Get All Audit Snapshots",
            notes = "Sample Test Api",
            response = AuditSnapshotResponse.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/snapshots"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    @Override
    public ResponseEntity<AuditSnapshotResponse> getStoresSnapshots() {
        return auditEventService.getStoresSnapshots();
    }

}
