package org.getarrayz.understandingjpa.repository;

import org.getarrayz.understandingjpa.entity.AddressEntity;
import org.getarrayz.understandingjpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, Integer> {
    Optional<List<AddressEntity>> findAddressEntitiesByUserEntity(UserEntity userEntity);
}
