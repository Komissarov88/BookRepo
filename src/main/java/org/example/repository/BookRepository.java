package org.example.repository;

import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.List;

@Component
public class BookRepository {

    private final Sql2o sql2o;

    private static final String SELECT_ALL_QUERY =
            "select * from public.book";
    private static final String SAVE_BOOK_QUERY =
            "insert into public.book (title, about, year) " +
                    "values (:title, :about, :year)";

    public BookRepository(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Book> findAll() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ALL_QUERY, false)
                    .setColumnMappings(Book.COLUMN_MAPPINGS)
                    .executeAndFetch(Book.class);
        }
    }

    public void save(Book book) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(SAVE_BOOK_QUERY, false)
                    .addParameter("title", book.getTitle())
                    .addParameter("about", book.getAbout())
                    .addParameter("year", book.getYear())
                    .setColumnMappings(Book.COLUMN_MAPPINGS)
                    .executeUpdate();
        }
    }
}
