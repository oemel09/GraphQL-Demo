package de.oemel09.GraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.oemel09.GraphQL.model.Author;
import de.oemel09.GraphQL.model.Book;
import de.oemel09.GraphQL.repository.AuthorRepository;
import de.oemel09.GraphQL.repository.BookRepository;

public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
