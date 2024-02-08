/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonActiveEntityJpaRepository;
import com.obsms.test.api.data.entity.Book;
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
public interface BookRepository extends AddonActiveEntityJpaRepository<Book> {

    @Query(value = "SELECT b FROM Book b WHERE b.name = :name")
    public Book getBookByName(@Param(value = "name") String name);

    @Query(value = "SELECT b FROM Book b WHERE b.active = true AND b.available = true")
    public List<Book> getAllByAvailability();

    @Query(value = "SELECT b FROM Book b WHERE b.active = true")
    @Override
    public List<Book> getAllByActivated();

    @Query(value = "SELECT b FROM Book b WHERE b.active = false")
    @Override
    public List<Book> getAllByDeactivated();

    @Modifying
    @Query(value = "UPDATE Book b SET b.active = true WHERE b.id = :id")
    @Override
    public void activate(@Param(value = "id") String id);

    @Modifying
    @Query(value = "UPDATE Book b SET b.active = false WHERE b.id = :id")
    @Override
    public void deactivate(@Param(value = "id") String id);
}
