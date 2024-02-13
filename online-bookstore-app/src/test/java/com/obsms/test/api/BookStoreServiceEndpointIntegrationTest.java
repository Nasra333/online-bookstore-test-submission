package com.obsms.test.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.obsms.test.api.abs.RequestStatus;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import com.obsms.test.api.data.entity.*;
import com.obsms.test.api.service.BookService;
import com.obsms.test.api.service.BookCategoryService;
import com.obsms.test.api.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BookStoreServiceEndpointIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private RepositoryAuditUserService auditUserService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UsersService userService;

    @Test
    public void test_get_all_repository_audit_users_thenStatus200()
            throws Exception {
        mvc.perform(get("/api/v1/getAuditUsers")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_user_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/addUser")
                        .content(convert2JsonString(new Users("ope", "ope", "Ope Samaad", auditUser, auditUser)))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_user_with_history_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        Users users = new Users("lommi", "lommi", "Lommi Samaad", auditUser, auditUser);
        users.setBrowseHistory(new UserBrowseHistory("Health:[]", users, auditUser, auditUser));

        mvc.perform(post("/api/v1/addUser")
                        .content(convert2JsonString(users))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_edit_user_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/editUser")
                        .content(convert2JsonString(userService.getByUsername("lommi")))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/addCategory")
                        .content(convert2JsonString(new BookCategory("Learning Language", auditUser, auditUser)))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_category_add_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        BookCategory communication = new BookCategory("Communication", auditUser, auditUser);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Art Of Human Communication", "John Doe", "Art Of Human Communication", "Communication", true, communication, auditUser, auditUser));
        books.add(new Book("Animal Communication", "John Doe", "Art Of Animal Communication", "Communication", true, communication, auditUser, auditUser));
        communication.setBooks(books);

        String converted = convert2JsonString(communication);
        mvc.perform(post("/api/v1/addCategory")
                        .content(convert2JsonString(converted))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_edit_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/editCategory")
                        .content(convert2JsonString(new BookCategory("Modern Economics", auditUser, auditUser)))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_deactivate_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/removeCategory")
                        .content(convert2JsonString(new BookCategory("Learning Language", auditUser, auditUser)))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_reactivate_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/activateCategory")
                        .content(convert2JsonString(new BookCategory("Learning Language", auditUser, auditUser)))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * Get all active category business data
     * @throws Exception
     */
    @Test
    public void test_get_all_active_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(get("/api/v1/getAllActiveCategory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * Get all active category business data both active and inactive
     * @throws Exception
     */
    @Test
    public void test_get_all_category_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(get("/api/v1/getAllCategory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        BookCategory bookCategory = bookCategoryService.getCategoryByName("Learning Language");

        Book book = new Book("Korean Language", "Yu Bin", "Learning Korean language","Learning Language", true, bookCategory, auditUser, auditUser);
        String converted = convert2JsonString(book);
        mvc.perform(post("/api/v1/addBook")
                        .content(converted)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_add_list_of_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        BookCategory bookCategory = bookCategoryService.getCategoryByName("Learning Language");

        List<Book> books = new ArrayList<>();
        books.add(new Book("Jamaican Creole", "Larry Whitebird", "Learning Jamaican creole", "Learning Language", true, bookCategory, auditUser, auditUser));
        books.add(new Book("The lost language of Australia", "Kiki Kuttu", "Australian Aboriginal lost language", "Learning Language", true, bookCategory, auditUser, auditUser));

        mvc.perform(post("/api/v1/addBooks")
                        .content(convert2JsonString(books))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_edit_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(post("/api/v1/editBook")
                        .content(convert2JsonString(bookService.getBookByName("Modern Economics")))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_deactivate_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        Book byName = bookService.getBookByName("Korean Language");

        mvc.perform(post("/api/v1/removeBook")
                        .content(convert2JsonString(byName))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_reactivate_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        Book byName = bookService.getBookByName("Korean Language");

        mvc.perform(post("/api/v1/activateBook")
                        .content(convert2JsonString(byName))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * Get all active/stocked book business data
     * @throws Exception
     */
    @Test
    public void test_get_all_stocked_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(get("/api/v1/getStockedBooks")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    /**
     * Get all active book business data both active/stocked and inactive/not-in-stock
     * @throws Exception
     */
    @Test
    public void test_get_all_available_book_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        mvc.perform(get("/api/v1/getBooksByAvailability")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_do_book_request_thenStatus200()
            throws Exception {
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();

        LendingRequest request = new LendingRequest();
        request.setStatus(RequestStatus.NEW);
        request.setUser(userService.getByUsername("walle"));
        request.setCreatedBy(auditUser);
        request.setLastModifiedBy(auditUser);

        List<LendingRequestLineItem> items = new ArrayList<>();
        items.add(new LendingRequestLineItem(bookService.getBookByName("Living Good"), request, auditUser, auditUser));
        items.add(new LendingRequestLineItem(bookService.getBookByName("Human Body"), request, auditUser, auditUser));
        request.setRequestLineItems(items);


        mvc.perform(post("/api/v1/createRequest")
                        .content(convert2JsonString(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpectAll(status().isOk(), content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    private static String convert2JsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String convert2GsonString(final Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
