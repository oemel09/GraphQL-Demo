package de.oemel09.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.model.Book;
import de.oemel09.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
