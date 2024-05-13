
package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.abs.data.AbstractPersistable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.commons.service.RepositoryAuditUserService;
import com.obsms.test.api.data.entity.*;
import com.obsms.test.api.service.BookCategoryService;
import com.obsms.test.api.service.DataChangeLogService;
import com.obsms.test.api.service.PersistableService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author ope
 */
@Service
@Scope("singleton")
public class PreloadedDataService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PreloadedDataService.class);

    @Autowired
    private DataChangeLogService logService;
    @Autowired
    private RepositoryAuditUserService auditUserService;
    @Autowired
    private PersistableService persistableService;
    @Autowired
    private BookCategoryService bookCategoryService;

    private Set<DataBaseChangeUpdate> updates = new HashSet<>();

    public PreloadedDataService() {
    }

    @PostConstruct
    private void initialize(){

        List<DataChangeLog> all = logService.getAll();
        RepositoryAuditUser auditUser = auditUserService.getSystemAuditUser();
        if (auditUser == null){
            auditUser = auditUserService.create(new RepositoryAuditUser("System", "System"));
        }

        //updates.add(new DataBaseChangeUpdate("1000000000", new RepositoryAuditUser("System", "System")));
        updates.add(new DataBaseChangeUpdate("1000000001", new AppSetting("app.name", "Test Online Bookstore Application", true)));
        updates.add(new DataBaseChangeUpdate("1000000002", new AppSetting("app.dev.mode", "DEVELOPMENT", false)));

        updates.add(new DataBaseChangeUpdate("1000000003", new BookCategory("Programming", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000004", new BookCategory("Software Architecture", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000005", new BookCategory("Government", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000006", new BookCategory("Economics", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000007", new BookCategory("Health", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000008", new BookCategory("Military", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000009", new BookCategory("Space", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000010", new BookCategory("Religion", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000011", new BookCategory("Contemporary History", auditUser, auditUser)));

        updates.add(new DataBaseChangeUpdate("1000000012", new Users("walle", "walle", "Ikram Samaad", auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000013", new Users("ikram", "ikram", "Ikram Samaad", auditUser, auditUser)));

        BookCategory category = bookCategoryService.getCategoryByName("Economics");
        updates.add(new DataBaseChangeUpdate("1000000014", new Book("Modern Economics", "Bob Dylan", "Book on modern economy","Economics", Boolean.TRUE, category, auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000015", new Book("Contemporary Economy", "Bob Dylan", "Book dynamics of contemporary economy","Economics", Boolean.TRUE, category, auditUser, auditUser)));
        category = bookCategoryService.getCategoryByName("Health");
        updates.add(new DataBaseChangeUpdate("1000000016", new Book("Living Good", "Karen Doe", "Book on good living","Health", Boolean.TRUE, category, auditUser, auditUser)));
        updates.add(new DataBaseChangeUpdate("1000000017", new Book("Human Body", "Karen Doe", "Book on human body","Health", Boolean.TRUE, category, auditUser, auditUser)));

        /**
         * Add new database change log before comment
         */
        Set<DataBaseChangeUpdate> updateSet = updates.stream()
                .filter(e -> all.stream().map(DataChangeLog::getChangeLog).noneMatch(d -> d.equals(e.getChangelogId())))
                .collect(Collectors.toSet());
        updateSet.iterator().forEachRemaining(e -> {
            persistableService.create(e.getPersistable());
            logService.create(new DataChangeLog(e.getChangelogId()));
        });
    }

    private String generateSerials() {
        return UUID.randomUUID().toString();
    }

}

class DataBaseChangeUpdate<T extends AbstractPersistable<String>>{

    private String changelogId;
    private T persistable;

    /**
     * constructor.
     *
     * @param changelogId
     * @param persistable
     */
    public DataBaseChangeUpdate(String changelogId, T persistable) {
        this.changelogId = changelogId;
        this.persistable = persistable;
    }

    public T update(Session session){
        return (T) session.merge(this);
    }

    public String getChangelogId() {
        return changelogId;
    }

    public T getPersistable() {
        return persistable;
    }
}
