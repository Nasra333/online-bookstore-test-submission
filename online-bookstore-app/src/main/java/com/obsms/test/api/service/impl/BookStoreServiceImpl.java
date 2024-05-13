package com.obsms.test.api.service.impl;

import com.obsms.test.api.abs.RequestStatus;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import com.obsms.test.api.data.entity.*;
import com.obsms.test.api.model.request.ApiOperationRequest;
import com.obsms.test.api.model.response.ApiOperationResponse;
import com.obsms.test.api.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Qualifier(value = "BookStoreServiceImpl")
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    private UsersService userService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LendingRequestService requestService;
    @Autowired
    private LendingRecordService recordService;
    @Autowired
    private RepositoryAuditUserService auditUserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookStoreServiceImpl.class);

    /**
     * @return {@link String}
     */
    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    @Override
    public ResponseEntity<Users> getUserByName(ApiOperationRequest<String> request) {
        Users users = userService.getByUsername(request.getRequestPayload());
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<Users> addUser(Users user) {
        Users created = userService.create(user);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<Users> editUser(Users user) {
        Users created = userService.update(user);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<List<Users>> getAllActiveUser() {
        return ResponseEntity.ok(userService.getAllByActivated());
    }

    @Override
    public ResponseEntity<List<Users>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    public ResponseEntity<BookCategory> addCategory(BookCategory bookCategory) {
        BookCategory created = bookCategoryService.create(bookCategory);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<BookCategory> editCategory(BookCategory bookCategory) {
        BookCategory updated = bookCategoryService.update(bookCategory);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<BookCategory> activateCategory(BookCategory bookCategory) {
        bookCategoryService.activate(bookCategory.getId());
        return ResponseEntity.ok(bookCategory);
    }

    @Override
    public ResponseEntity<BookCategory> removeCategory(BookCategory bookCategory) {
        bookCategoryService.deactivate(bookCategory.getId());
        return ResponseEntity.ok(bookCategory);
    }

    @Override
    public ResponseEntity<BookCategory> getCategoryByName(ApiOperationRequest<String> request) {
        return ResponseEntity.ok(bookCategoryService.getCategoryByName(request.getRequestPayload()));
    }

    @Override
    public ResponseEntity<List<BookCategory>> getAllActiveCategory() {
        return ResponseEntity.ok(bookCategoryService.getAllByActivated());
    }

    @Override
    public ResponseEntity<List<BookCategory>> getAllCategory() {
        return ResponseEntity.ok(bookCategoryService.getAll());
    }

    @Override
    public ResponseEntity<Book> addBook(Book book) {
        book.setBookCategory(bookCategoryService.getCategoryByName(book.getCategoryName()));
        Book created = bookService.create(book);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<List<Book>> addBooks(List<Book> books) {
        books.forEach(e -> {
            e.setBookCategory(bookCategoryService.getCategoryByName(e.getCategoryName()));
        });
        List<Book> list = bookService.create(books);
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<Book> editBook(Book book) {
        book.setBookCategory(bookCategoryService.getCategoryByName(book.getCategoryName()));
        Book updated = bookService.update(book);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Book> removeBook(Book book) {
        bookService.deactivate(book.getId());
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> activateBook(Book book) {
        bookService.activate(book.getId());
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<Book> getBookByName(ApiOperationRequest<String> request) {
        Book book = bookService.getBookByName(request.getRequestPayload());
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<List<Book>> getStockedBooks() {
        return ResponseEntity.ok(bookService.getAllByActivated());
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByAvailability() {
        return ResponseEntity.ok(bookService.getAllByAvailability());
    }

    @Override
    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @Override
    public ResponseEntity<LendingRequest> onlineBookRequest(LendingRequest request) {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        LendingRecord record = new LendingRecord();
        record.setLendingRequest(request);
        record.setCreatedBy(auditUser);
        record.setLastModifiedBy(auditUser);
        record.setReturnDate(Date.from(LocalDateTime.now().plusDays(14).atZone(ZoneId.systemDefault()).toInstant()));
        request.setRecord(record);
        request.getRequestLineItems().forEach(e -> {
            e.getBook().setAvailable(Boolean.FALSE);
            e.getBook().setBookCategory(bookCategoryService.getCategoryByName(e.getBook().getCategoryName()));
        });
        request.setTrackingNumber(generateTrackingNumber());
        request.setStatus(RequestStatus.APPROVED);
        LendingRequest lendingRequest = requestService.create(request);
        return ResponseEntity.ok(lendingRequest);
    }

    @Override
    public ResponseEntity<List<RepositoryAuditUser>> getAuditUsers() {
        return ResponseEntity.ok(auditUserService.getAll());
    }
}
