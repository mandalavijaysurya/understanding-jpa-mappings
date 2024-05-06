package org.getarrayz.understandingjpa.repository;

import org.getarrayz.understandingjpa.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findById(long id);
}
