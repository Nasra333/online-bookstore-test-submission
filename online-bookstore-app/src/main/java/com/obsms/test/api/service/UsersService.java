package com.obsms.test.api.service;

import com.obsms.test.api.commons.abs.data.AddonCRUDService;
import com.obsms.test.api.data.entity.Users;

public interface UsersService extends AddonCRUDService<Users> {


    /**
     *
     * @param userName
     * @return {@link Users}
     */
    Users getByUsername(String userName);
}
