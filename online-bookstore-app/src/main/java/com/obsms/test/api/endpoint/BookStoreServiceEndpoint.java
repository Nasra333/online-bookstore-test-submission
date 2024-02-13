package com.obsms.test.api.endpoint;

import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.data.entity.Book;
import com.obsms.test.api.data.entity.BookCategory;
import com.obsms.test.api.data.entity.LendingRequest;
import com.obsms.test.api.data.entity.Users;
import com.obsms.test.api.model.request.ApiOperationRequest;
import com.obsms.test.api.model.response.ApiOperationResponse;
import com.obsms.test.api.service.BookStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author walles
 */
@RestController
@CrossOrigin
@RequestMapping(value = {"/api/v1"}, produces = {"application/json"})
@Api(value = "Test Online Bookstore Service Api", protocols = "http, https")
@Transactional
@Primary
public class BookStoreServiceEndpoint implements BookStoreService {

    @Autowired
    @Qualifier(value = "BookStoreServiceImpl")
    private BookStoreService service;

    /**
     * @param request
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get a single user by name",
            notes = "Sample Test Api",
            response = Users.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getUserByName"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Users> getUserByName(@RequestBody ApiOperationRequest<String> request){
        return service.getUserByName(request);
    }

    /**
     * @param user
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create/add a new user",
            notes = "Sample Test Api",
            response = Users.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/addUser"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        return service.addUser(user);
    }

    /**
     * @param user
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Edit/update a user",
            notes = "Sample Test Api",
            response = Users.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/editUser"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Users> editUser(@RequestBody Users user){
        return service.editUser(user);
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all active user",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAllActiveUser"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<Users>> getAllActiveUser(){
        return service.getAllActiveUser();
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all user both active and inactive",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAllUser"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<Users>> getAllUser(){
        return service.getAllUser();
    }

    @ApiOperation(value = "Create/add a new category",
            notes = "Sample Test Api",
            response = BookCategory.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/addCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    @Override
    public ResponseEntity<BookCategory> addCategory(@RequestBody BookCategory bookCategory) {
        return service.addCategory(bookCategory);
    }

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Edit/update category",
            notes = "Sample Test Api",
            response = BookCategory.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/editCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<BookCategory> editCategory(@RequestBody BookCategory bookCategory) {
        return service.editCategory(bookCategory);
    }

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Re-activate category",
            notes = "Sample Test Api",
            response = BookCategory.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/activateCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<BookCategory> activateCategory(@RequestBody BookCategory bookCategory){
        return service.activateCategory(bookCategory);
    }

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Delete/Deactivate category",
            notes = "Sample Test Api",
            response = BookCategory.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/removeCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<BookCategory> removeCategory(@RequestBody BookCategory bookCategory){
        return service.removeCategory(bookCategory);
    }

    /**
     * @param request
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get a single category by name",
            notes = "Sample Test Api",
            response = BookCategory.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getCategoryByName"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<BookCategory> getCategoryByName(@RequestBody ApiOperationRequest<String> request){
        return service.getCategoryByName(request);
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all category",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAllActiveCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<BookCategory>> getAllActiveCategory() {
        return service.getAllActiveCategory();
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all category both active and inactive",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAllCategory"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<BookCategory>> getAllCategory(){
        return service.getAllCategory();
    }

    @ApiOperation(value = "Create/add a new book",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/addBook"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    @Override
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @ApiOperation(value = "Create/add a list of new book",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/addBooks"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    @Override
    public ResponseEntity<List<Book>> addBooks(List<Book> books) {
        return service.addBooks(books);
    }

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Edit/update book",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/editBook"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        return service.editBook(book);
    }

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Delete/Deactivate book",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/removeBook"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Book> removeBook(@RequestBody Book book){
        return service.removeBook(book);
    }

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Re-activate book",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/activateBook"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Book> activateBook(@RequestBody Book book){
        return service.activateBook(book);
    }

    /**
     * @param request
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get a single book by name",
            notes = "Sample Test Api",
            response = Book.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getBookByName"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<Book> getBookByName(@RequestBody ApiOperationRequest<String> request){
        return service.getBookByName(request);
    }

    @ApiOperation(value = "Get all Book in stock",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getStockedBooks"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    @Override
    public ResponseEntity<List<Book>> getStockedBooks() {
        return service.getStockedBooks();
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all Book in stock and available for lending",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getBooksByAvailability"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<Book>> getBooksByAvailability() {
        return service.getBooksByAvailability();
    }

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all Book both active and inactive",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAllBook"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<List<Book>> getAllBook(){
        return service.getAllBook();
    }

    /**
     * @param request
     * @return {@link ResponseEntity}
     */
    @Override
    @ApiOperation(value = "Create a new book borrowing order request",
            notes = "Sample Test Api",
            response = LendingRequest.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/createRequest"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<LendingRequest> onlineBookRequest(@RequestBody LendingRequest request) {
        return service.onlineBookRequest(request);
    }

    @ApiOperation(value = "Get all audit users",
            notes = "Sample Test Api",
            response = List.class)
    @ApiResponses({@ApiResponse(code = 200, message = "The response was successfully processed."
    ), @ApiResponse(code = 400, message = "Bad request - credentials were not passed"
    ), @ApiResponse(code = 401, message = "Unauthorized request - the authentication failed"
    ), @ApiResponse(code = 500, message = "An internal error has occurred.")})
    @RequestMapping(
            value = {"/getAuditUsers"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.GET}
    )
    @Override
    public ResponseEntity<List<RepositoryAuditUser>> getAuditUsers() {
        return service.getAuditUsers();
    }
}
