package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractActiveCRUDService;
import com.obsms.test.api.data.entity.BookCategory;
import com.obsms.test.api.data.repository.BookCategoryRepository;
import com.obsms.test.api.service.BookCategoryService;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryServiceImpl
        extends AbstractActiveCRUDService<BookCategory, BookCategoryRepository>
        implements BookCategoryService {

    @Override
    public BookCategory getCategoryByName(String name) {
        return repository.getCategoryByName(name);
    }
}
