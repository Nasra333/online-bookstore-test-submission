package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.Book;
import com.obsms.test.api.data.repository.BookRepository;
import com.obsms.test.api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl
        extends AbstractActiveCRUDService<Book, BookRepository>
        implements BookService {

    @Override
    public List<Book> getAllByAvailability() {
        return repository.getAllByAvailability();
    }

    @Override
    public Book getBookByName(String name) {
        return repository.getBookByName(name);
    }
}
