package de.oemel09.GraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.oemel09.GraphQL.model.Author;
import de.oemel09.GraphQL.model.Book;
import de.oemel09.GraphQL.repository.AuthorRepository;
import de.oemel09.GraphQL.repository.BookRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Long id, Integer pageCount) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setPageCount(pageCount);
            return bookRepository.save(book);
        }
        return null;
    }
}
