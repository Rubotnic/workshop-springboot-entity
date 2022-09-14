package se.lexicon.workshopspringbootentity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopspringbootentity.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookLoanImpl implements BookLoanDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public BookLoan findById(int loanId) {
        return entityManager.find(BookLoan.class, loanId);
    }

    @Transactional
    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT bookloan FROM BookLoan bookloan", BookLoan.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int loanId) {
        entityManager.remove(findById(loanId));
    }
}
