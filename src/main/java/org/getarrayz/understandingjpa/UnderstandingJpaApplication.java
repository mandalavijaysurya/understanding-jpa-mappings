package org.getarrayz.understandingjpa;

import org.getarrayz.understandingjpa.entity.Person;
import org.getarrayz.understandingjpa.repository.PagingExample;
import org.getarrayz.understandingjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.NoSuchElementException;

@SpringBootApplication
public class UnderstandingJpaApplication {

    @Autowired
    private PagingExample pagingExample;

    public static void main(String[] args) {
        SpringApplication.run(UnderstandingJpaApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(PersonRepository repository){
        return args -> {
            Person person = new Person();
            person.setName("Vijay");
            repository.save(person);
            repository.save(person);
            Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
            Page<Person> persons = pagingExample.findAll(PageRequest.of(0,10));
            System.out.println(saved);
            persons.stream().forEach(System.out::println);
        };
    }
}
