package org.getarrayz.understandingjpa.repository;

import org.getarrayz.understandingjpa.entity.InterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface InterestEntityRepository extends JpaRepository<InterestEntity, Integer> {
    Optional<InterestEntity> findByName(String name);
}
