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
import se.lexicon.workshopspringbootentity.entity.BookLoan;
import se.lexicon.workshopspringbootentity.entity.Details;

import java.time.LocalDate;
import java.util.List;

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


        return null;
    }
}

