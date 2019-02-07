package de.oemel09.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.model.Book;
import de.oemel09.graphql.repository.AuthorRepository;
import de.oemel09.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class AuthorMutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }
}
