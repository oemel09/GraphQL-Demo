package de.oemel09.GraphQL.repository;

import de.oemel09.GraphQL.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
