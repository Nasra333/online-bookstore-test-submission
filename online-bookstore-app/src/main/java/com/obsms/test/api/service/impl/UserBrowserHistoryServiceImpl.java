package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.UserBrowseHistory;
import com.obsms.test.api.data.repository.UserBrowseHistoryRepository;
import com.obsms.test.api.service.UserBrowseHistoryService;
import org.springframework.stereotype.Service;

@Service
public class UserBrowserHistoryServiceImpl
        extends AbstractActiveCRUDService<UserBrowseHistory, UserBrowseHistoryRepository>
        implements UserBrowseHistoryService {
}
