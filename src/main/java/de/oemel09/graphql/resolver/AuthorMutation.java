package de.oemel09.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

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

    public boolean deleteAuthor(Long id) {
        try {
            authorRepository.deleteById(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            System.out.println("Failed to delete author, there is still a book saved written by this author!");
            return false;
        }
    }
}
