package de.oemel09.GraphQL.repository;

import de.oemel09.GraphQL.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
