package com.obsms.test.api.service.impl;

import com.obsms.test.api.model.request.RoleUsers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("singleton")
public class AppRoleUserRegistryMapper {

    private Map<String, RoleUsers> mapper = new HashMap<>();

    /**
     * @param user
     */
    public RoleUsers addUserinfo(RoleUsers user) {
        RoleUsers userInfo = getUserInfo(user.getUserName());
        if (userInfo != null) {
            mapper.remove(user.getUserName());
        }
        return mapper.put(user.getUserName(), user);
    }

    public RoleUsers removeUserinfo(RoleUsers user) {
        return mapper.remove(user.getUserName());
    }

    /**
     * @param roleName
     * @return {@link RoleUsers}
     */
    public RoleUsers getUserInfo(String roleName) {
        return mapper.get(roleName);
    }

    /**
     * @return {@link List}
     */
    public List<RoleUsers> getAllUserInfo() {
        return new ArrayList<>(mapper.values());
    }

    /**
     *
     */
    @PreDestroy
    public void discard() {
        mapper.clear();
    }
}
