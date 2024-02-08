package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractAddonCRUDService;
import com.obsms.test.api.commons.abs.data.AbstractPersistable;
import com.obsms.test.api.data.entity.AppSetting;
import com.obsms.test.api.data.repository.AppSettingRepository;
import com.obsms.test.api.data.repository.PersistableRepository;
import com.obsms.test.api.service.AppSettingService;
import com.obsms.test.api.service.PersistableService;
import org.springframework.stereotype.Service;

@Service
public class PersistableServiceImpl
        extends AbstractAddonCRUDService<AbstractPersistable<String>, PersistableRepository>
        implements PersistableService {
}
