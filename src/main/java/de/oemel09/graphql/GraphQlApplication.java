package de.oemel09.graphql;

import de.oemel09.graphql.model.Author;
import de.oemel09.graphql.model.Book;
import de.oemel09.graphql.repository.AuthorRepository;
import de.oemel09.graphql.repository.BookRepository;
import de.oemel09.graphql.resolver.BookResolver;
import de.oemel09.graphql.resolver.Mutation;
import de.oemel09.graphql.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }

    @Bean
    public BookResolver authorResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Mutation(authorRepository, bookRepository);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> createBooks(bookRepository, createAuthors(authorRepository));
    }

    private ArrayList<Author> createAuthors(AuthorRepository authorRepository) {
        ArrayList<Author> authors = new ArrayList<>();

        authors.add(authorRepository.save(new Author("Herbert", "Schildt")));
        authors.add(authorRepository.save(new Author("Rene", "Enriquez")));
        authors.add(authorRepository.save(new Author("Brian W.", "Kernighan")));

        return authors;
    }

    private void createBooks(BookRepository bookRepository, List<Author> authorList) {
        bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, authorList.get(0)));
        bookRepository.save(new Book("Software Architecture with Spring 5.0", "9781788992992", 372, authorList.get(1)));
        bookRepository.save(new Book("RESTful Java Web Services Security", "9781783980109", 144, authorList.get(1)));
        bookRepository.save(new Book("C Programming Language, 2nd Edition", "0131103628", 272, authorList.get(2)));
    }
}
