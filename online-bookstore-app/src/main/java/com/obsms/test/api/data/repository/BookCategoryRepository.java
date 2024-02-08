/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonActiveEntityJpaRepository;
import com.obsms.test.api.data.entity.BookCategory;
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
public interface BookCategoryRepository extends AddonActiveEntityJpaRepository<BookCategory> {

    @Query(value = "SELECT c FROM BookCategory c WHERE c.name = :name")
    public BookCategory getCategoryByName(@Param(value = "name") String name);

    @Query(value = "SELECT c FROM BookCategory c WHERE c.active = true")
    @Override
    public List<BookCategory> getAllByActivated();

    @Query(value = "SELECT c FROM BookCategory c WHERE c.active = false")
    @Override
    public List<BookCategory> getAllByDeactivated();

    @Modifying
    @Query(value = "UPDATE BookCategory c SET c.active = true WHERE c.id = :id")
    @Override
    public void activate(@Param(value = "id") String id);

    @Modifying
    @Query(value = "UPDATE BookCategory c SET c.active = false WHERE c.id = :id")
    @Override
    public void deactivate(@Param(value = "id") String id);
}
