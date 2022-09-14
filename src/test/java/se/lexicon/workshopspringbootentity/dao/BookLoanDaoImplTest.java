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
import se.lexicon.workshopspringbootentity.entity.Book;
import se.lexicon.workshopspringbootentity.entity.BookLoan;
import se.lexicon.workshopspringbootentity.entity.Details;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional
class BookLoanDaoImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookLoanDao bookLoanDao;

    private BookLoan testObject;

    public List<AppUser> appUsers() {
        return Arrays.asList(
        new AppUser("kalleuser", "losenpass",
                new Details("kalle@mail.com", "Kalle Kallesson", LocalDate.parse("2022-12-12"))),
                new AppUser("stefanuser", "losenpass2",
                        new Details("stefan@mail.com", "Stefan Stefansson", LocalDate.parse("2022-11-11")))
                );
    }

    public List<Book> books(){
        return Arrays.asList(
                new Book("123345455", "Den magiska boken", 15),
                new Book("212121", "Boken som är inte magisk", 15)
        );
    }


    @BeforeEach
    void setUp() {
        List<AppUser> prisistedAppUsers = appUsers().stream().map(entityManager::persist).collect(Collectors.toList());

        List<Book> persistedBooks = books().stream().map(entityManager::persist).collect(Collectors.toList());

        List<BookLoan> bookLoans = new ArrayList<>(
                Arrays.asList(
                        new BookLoan(LocalDate.now(), LocalDate.now().plusDays(50), false, prisistedAppUsers.get(0), persistedBooks.get(0)),

                        new BookLoan(LocalDate.now(), LocalDate.now().plusDays(30), false, prisistedAppUsers.get(0), persistedBooks.get(1))

                )
        );

        List<BookLoan> persistedBookLoans = bookLoans.stream().map(entityManager::persist).collect(Collectors.toList());


    }

    @Test
    void findById() {

    }

    @Test
    void findAll() {
        assertEquals(2,bookLoanDao.findAll().size());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}

