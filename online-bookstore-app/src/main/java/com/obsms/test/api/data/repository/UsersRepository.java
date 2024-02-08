/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonActiveEntityJpaRepository;
import com.obsms.test.api.data.entity.Users;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ope
 */
@JaversSpringDataAuditable
@Repository
public interface UsersRepository extends AddonActiveEntityJpaRepository<Users> {

    @Query(value = "SELECT u FROM Users u WHERE u.userName = :userName")
    public Users getByUsername(@Param(value = "userName") String userName);

    @Query(value = "SELECT u FROM Users u WHERE u.active = true")
    @Override
    public List<Users> getAllByActivated();

    @Query(value = "SELECT u FROM Users u WHERE u.active = false")
    @Override
    public List<Users> getAllByDeactivated();

    @Modifying
    @Query(value = "UPDATE Users u SET u.active = true WHERE u.id = :id")
    @Override
    public void activate(@Param(value = "id") String id);

    @Modifying
    @Query(value = "UPDATE Users u SET u.active = false WHERE u.id = :id")
    @Override
    public void deactivate(@Param(value = "id") String id);
}
