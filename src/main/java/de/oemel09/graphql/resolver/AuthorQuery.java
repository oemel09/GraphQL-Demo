package de.oemel09.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.model.Book;
import de.oemel09.graphql.repository.AuthorRepository;
import de.oemel09.graphql.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorQuery implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    public AuthorQuery(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
