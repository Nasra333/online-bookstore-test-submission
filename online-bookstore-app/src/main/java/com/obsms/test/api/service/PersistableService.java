package com.obsms.test.api.service;

import com.obsms.test.api.commons.abs.data.AbstractPersistable;
import com.obsms.test.api.commons.abs.data.CRUDService;
import com.obsms.test.api.commons.abs.data.Persistable;
import com.obsms.test.api.data.entity.AppSetting;

public interface PersistableService extends CRUDService<AbstractPersistable<String>> {
}
