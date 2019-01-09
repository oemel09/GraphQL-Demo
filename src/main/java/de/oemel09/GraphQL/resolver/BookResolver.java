package de.oemel09.GraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.oemel09.GraphQL.model.Author;
import de.oemel09.GraphQL.model.Book;
import de.oemel09.GraphQL.repository.AuthorRepository;

import java.util.Optional;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
