package com.obsms.test.api.service;

import com.obsms.test.api.commons.abs.data.AddonCRUDService;
import com.obsms.test.api.data.entity.Book;

import java.util.List;

public interface BookService extends AddonCRUDService<Book> {

    /**
     *
     * @return {@link List}
     */
    List<Book> getAllByAvailability();

    /**
     *
     * @return {@link String}
     */
    Book getBookByName(String name);
}
