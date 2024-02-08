package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractAddonCRUDService;
import com.obsms.test.api.data.entity.DataChangeLog;
import com.obsms.test.api.data.repository.DataChangeLogRepository;
import com.obsms.test.api.service.DataChangeLogService;
import org.springframework.stereotype.Service;

@Service
public class DataChangeLogServiceImpl
        extends AbstractAddonCRUDService<DataChangeLog, DataChangeLogRepository>
        implements DataChangeLogService {
}
