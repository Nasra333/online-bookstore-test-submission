package com.obsms.test.api.service.impl;

import com.obsms.test.api.abs.RequestStatus;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import com.obsms.test.api.data.entity.*;
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
    public ResponseEntity<ApiOperationResponse<Users>> addUser(Users user) {
        Users created = userService.create(user);
        ApiOperationResponse<Users> response = ApiOperationResponse.<Users>builder()
                .responsePayload(created)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("New user added successfully")
                .build();
        return ResponseEntity.ok(response);
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
    public ResponseEntity<ApiOperationResponse<BookCategory>> addCategory(BookCategory bookCategory) {
        BookCategory created = bookCategoryService.create(bookCategory);
        ApiOperationResponse<BookCategory> response = ApiOperationResponse.<BookCategory>builder()
                .responsePayload(created)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("New category added successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<BookCategory>> editCategory(BookCategory bookCategory) {
        BookCategory updated = bookCategoryService.update(bookCategory);
        ApiOperationResponse<BookCategory> response = ApiOperationResponse.<BookCategory>builder()
                .responsePayload(updated)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Category updated successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<BookCategory>> activateCategory(BookCategory bookCategory) {
        bookCategoryService.activate(bookCategory.getId());
        ApiOperationResponse<BookCategory> response = ApiOperationResponse.<BookCategory>builder()
                .responsePayload(bookCategory)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Category re-activated successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<BookCategory>> removeCategory(BookCategory bookCategory) {
        bookCategoryService.deactivate(bookCategory.getId());
        ApiOperationResponse<BookCategory> response = ApiOperationResponse.<BookCategory>builder()
                .responsePayload(bookCategory)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Category deactivated successfully")
                .build();
        return ResponseEntity.ok(response);
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
    public ResponseEntity<ApiOperationResponse<Book>> addBook(Book book) {
        Book created = bookService.create(book);
        ApiOperationResponse<Book> response = ApiOperationResponse.<Book>builder()
                .responsePayload(created)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("New book added successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<List<Book>>> addBooks(List<Book> books) {
        List<Book> list = bookService.create(books);
        ApiOperationResponse<List<Book>> response = ApiOperationResponse.<List<Book>>builder()
                .responsePayload(list)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("New books added successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<Book>> editBook(Book book) {
        Book updated = bookService.update(book);
        ApiOperationResponse<Book> response = ApiOperationResponse.<Book>builder()
                .responsePayload(updated)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Book updated successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<Book>> removeBook(Book book) {
        bookService.deactivate(book.getId());
        ApiOperationResponse<Book> response = ApiOperationResponse.<Book>builder()
                .responsePayload(book)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Book deactivated successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiOperationResponse<Book>> activateBook(Book book) {
        bookService.activate(book.getId());
        ApiOperationResponse<Book> response = ApiOperationResponse.<Book>builder()
                .responsePayload(book)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Book re-activated successfully")
                .build();
        return ResponseEntity.ok(response);
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
    public ResponseEntity<ApiOperationResponse<LendingRequest>> onlineBookRequest(LendingRequest request) {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        LendingRecord record = new LendingRecord();
        record.setLendingRequest(request);
        record.setCreatedBy(auditUser);
        record.setLastModifiedBy(auditUser);
        record.setReturnDate(Date.from(LocalDateTime.now().plusDays(14).atZone(ZoneId.systemDefault()).toInstant()));
        request.setRecord(record);
        request.getRequestLineItems().forEach(e -> e.getBook().setAvailable(Boolean.FALSE));
        request.setTrackingNumber(generateTrackingNumber());
        request.setStatus(RequestStatus.APPROVED);
        LendingRequest lendingRequest = requestService.create(request);
        ApiOperationResponse<LendingRequest> response = ApiOperationResponse.<LendingRequest>builder()
                .responsePayload(lendingRequest)
                .responseCode(ApiOperationResponse.ResponseCodeEnum.SUCCESS)
                .responseMessage("Book lending request processed successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<RepositoryAuditUser>> getAuditUsers() {
        return ResponseEntity.ok(auditUserService.getAll());
    }
}
