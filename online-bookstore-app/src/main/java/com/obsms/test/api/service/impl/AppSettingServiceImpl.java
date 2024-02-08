package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractAddonCRUDService;
import com.obsms.test.api.data.entity.AppSetting;
import com.obsms.test.api.data.repository.AppSettingRepository;
import com.obsms.test.api.service.AppSettingService;
import org.springframework.stereotype.Service;

@Service
public class AppSettingServiceImpl
        extends AbstractAddonCRUDService<AppSetting, AppSettingRepository>
        implements AppSettingService {
}
