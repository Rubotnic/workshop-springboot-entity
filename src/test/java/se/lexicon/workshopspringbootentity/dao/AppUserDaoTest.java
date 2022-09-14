package se.lexicon.workshopspringbootentity.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopspringbootentity.entity.AppUser;
import se.lexicon.workshopspringbootentity.entity.Details;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional
class AppUserDaoTest {


    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AppUserDao appUserDao;
    private AppUser testObject;

    public List<AppUser> appUsers(){
        return Arrays.asList(
                new AppUser("kalleuser", "losenpass", new Details("kalle@mail.com", "Kalle Kallesson", LocalDate.parse("2022-12-12"))),
                new AppUser("stefanuser", "losenpass2", new Details("stefan@mail.com", "Stefan Stefansson", LocalDate.parse("2022-11-11")))

        );
    }


    @BeforeEach
    void setUp() {

        List<AppUser> persistedAppUsers = appUsers().stream().map(entityManager::persist).collect(Collectors.toList());
        testObject = persistedAppUsers.get(0);
    }

    @Test
    void findById() {
        AppUser foundAppUser = appUserDao.findById(testObject.getAppUserId());
        assertNotNull(foundAppUser);
    }

    @Test
    void findAll() {

        Collection<AppUser> found = appUserDao.findAll();
        assertNotNull(found);
        assertEquals(2, found.size());
    }

    @Test
    void create() {

        AppUser appUser = new AppUser("usernamn2", "losenpass2", new Details("mail2@mail.com", "Stefan Stefansson", LocalDate.parse("2022-11-11")));
        AppUser presistedUser = appUserDao.create(appUser);
        assertNotNull(presistedUser);
        assertNotEquals(0, presistedUser.getAppUserId());
        assertNotNull(entityManager.find(AppUser.class, presistedUser.getAppUserId()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

        assertNotNull(entityManager.find(AppUser.class, testObject.getAppUserId()));
        appUserDao.delete(testObject.getAppUserId());
        assertNull(entityManager.find(AppUser.class, testObject.getAppUserId()));
    }
}