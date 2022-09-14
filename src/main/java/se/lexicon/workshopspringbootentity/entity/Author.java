package se.lexicon.workshopspringbootentity.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String firstname;
    private String lastname;


    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Book> writtenBooks;


    public Author() {}

    public Author(int authorId, String firstname, String lastname, Set<Book> writtenBooks) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.writtenBooks = writtenBooks;
    }

    public Author(String firstname, String lastname, Set<Book> writtenBooks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.writtenBooks = writtenBooks;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(firstname, author.firstname) && Objects.equals(lastname, author.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstname, lastname);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}
