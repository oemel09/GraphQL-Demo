package de.oemel09.graphql.repository;

import de.oemel09.graphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
