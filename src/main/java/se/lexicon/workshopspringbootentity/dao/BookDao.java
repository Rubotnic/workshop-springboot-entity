package se.lexicon.workshopspringbootentity.dao;

import se.lexicon.workshopspringbootentity.entity.AppUser;
import se.lexicon.workshopspringbootentity.entity.Book;

import java.util.Collection;

public interface BookDao {

    Book findById(int bookId);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int bookId);

}
