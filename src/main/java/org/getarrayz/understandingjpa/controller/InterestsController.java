package org.getarrayz.understandingjpa.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.getarrayz.understandingjpa.dto.Interest;
import org.getarrayz.understandingjpa.entity.InterestEntity;
import org.getarrayz.understandingjpa.exception.InterestNotFoundException;
import org.getarrayz.understandingjpa.repository.InterestEntityRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class InterestsController {
    private final InterestEntityRepository interestEntityRepository;
    @RequestMapping(value = "/interests/add", method = RequestMethod.POST)
    public String addInterests(@RequestBody Interest interest){
        log.info("Interest: {}",interest);
        InterestEntity interestEntity = InterestEntity.builder()
                .name(interest.getName()).build();
        interestEntityRepository.save(interestEntity);
        return "Requested interests have been added";
    }
}
