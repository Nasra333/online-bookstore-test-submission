package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.Users;
import com.obsms.test.api.data.repository.UsersRepository;
import com.obsms.test.api.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl
        extends AbstractActiveCRUDService<Users, UsersRepository>
        implements UsersService {

    @Override
    public Users getByUsername(String userName) {
        return repository.getByUsername(userName);
    }
}
