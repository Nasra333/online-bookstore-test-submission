package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.LendingRecord;
import com.obsms.test.api.data.repository.LendingRecordRepository;
import com.obsms.test.api.service.LendingRecordService;
import org.springframework.stereotype.Service;

@Service
public class LendingRecordServiceImpl
        extends AbstractActiveCRUDService<LendingRecord, LendingRecordRepository>
        implements LendingRecordService {
}
