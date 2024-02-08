package com.obsms.test.api.service;

import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.data.entity.Book;
import com.obsms.test.api.data.entity.BookCategory;
import com.obsms.test.api.data.entity.LendingRequest;
import com.obsms.test.api.data.entity.Users;
import com.obsms.test.api.model.response.ApiOperationResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface BookStoreService {

    /**
     * @param user
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create/add a new user",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<Users>> addUser(@RequestBody Users user);

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
    ResponseEntity<List<Users>> getAllActiveUser();

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
    ResponseEntity<List<Users>> getAllUser();

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create/add a new category",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<BookCategory>> addCategory(@RequestBody BookCategory bookCategory);

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Edit/update category",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<BookCategory>> editCategory(@RequestBody BookCategory bookCategory);

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Re-activate category",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<BookCategory>> activateCategory(@RequestBody BookCategory bookCategory);

    /**
     * @param bookCategory
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Delete/Deactivate category",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<BookCategory>> removeCategory(@RequestBody BookCategory bookCategory);

    /**
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Get all active category",
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
    ResponseEntity<List<BookCategory>> getAllActiveCategory();

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
    ResponseEntity<List<BookCategory>> getAllCategory();

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create/add a new book",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<Book>> addBook(@RequestBody Book book);

    /**
     * @param books
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create/add a list of new book",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<List<Book>>> addBooks(@RequestBody List<Book> books);

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Edit/update book",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<Book>> editBook(@RequestBody Book book);

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Delete/Deactivate book",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<Book>> removeBook(@RequestBody Book book);

    /**
     * @param book
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Re-activate book",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<Book>> activateBook(@RequestBody Book book);

    /**
     * @return {@link ResponseEntity}
     */
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
    ResponseEntity<List<Book>> getStockedBooks();

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
    ResponseEntity<List<Book>> getBooksByAvailability();

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
    ResponseEntity<List<Book>> getAllBook();

    /**
     * @param request
     * @return {@link ResponseEntity}
     */
    @ApiOperation(value = "Create a new book borrowing order request",
            notes = "Sample Test Api",
            response = ApiOperationResponse.class)
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
    ResponseEntity<ApiOperationResponse<LendingRequest>> onlineBookRequest(@RequestBody LendingRequest request);

    /**
     * @return {@link ResponseEntity}
     */
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
    ResponseEntity<List<RepositoryAuditUser>> getAuditUsers();
}
