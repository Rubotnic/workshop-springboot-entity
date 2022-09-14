package se.lexicon.workshopspringbootentity.dao;

import se.lexicon.workshopspringbootentity.entity.AppUser;
import se.lexicon.workshopspringbootentity.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {

    BookLoan findById(int loanId);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int loanId);
}
