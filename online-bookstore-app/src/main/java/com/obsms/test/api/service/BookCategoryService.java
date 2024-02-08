package com.obsms.test.api.service;

import com.obsms.test.api.commons.abs.data.AddonCRUDService;
import com.obsms.test.api.data.entity.BookCategory;

public interface BookCategoryService extends AddonCRUDService<BookCategory> {

    /**
     *
     * @param name
     * @return {@link String}
     */
    BookCategory getCategoryByName(String name);
}
