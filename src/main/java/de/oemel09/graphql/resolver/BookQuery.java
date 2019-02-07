package de.oemel09.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.model.Book;
import de.oemel09.graphql.repository.AuthorRepository;
import de.oemel09.graphql.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookQuery implements GraphQLQueryResolver {

    private BookRepository bookRepository;

    public BookQuery(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
