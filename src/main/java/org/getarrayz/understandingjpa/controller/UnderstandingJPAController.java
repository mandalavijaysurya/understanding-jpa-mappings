package org.getarrayz.understandingjpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.getarrayz.understandingjpa.dto.Address;
import org.getarrayz.understandingjpa.dto.Interest;
import org.getarrayz.understandingjpa.dto.User;
import org.getarrayz.understandingjpa.entity.AddressEntity;
import org.getarrayz.understandingjpa.entity.InterestEntity;
import org.getarrayz.understandingjpa.entity.UserEntity;
import org.getarrayz.understandingjpa.exception.AddressNotFoundException;
import org.getarrayz.understandingjpa.exception.InterestNotFoundException;
import org.getarrayz.understandingjpa.exception.UserNotFoundException;
import org.getarrayz.understandingjpa.repository.AddressEntityRepository;
import org.getarrayz.understandingjpa.repository.InterestEntityRepository;
import org.getarrayz.understandingjpa.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@RestController
@Slf4j
public class UnderstandingJPAController{
    private final UserEntityRepository userEntityRepository;
    private final AddressEntityRepository addressEntityRepository;
    private final InterestEntityRepository interestEntityRepository;

    public UnderstandingJPAController(@Autowired UserEntityRepository repository, AddressEntityRepository addressEntityRepository, InterestEntityRepository interestEntityRepository, ObjectMapper objectMapper){
        this.userEntityRepository = repository;
        this.addressEntityRepository = addressEntityRepository;
        this.interestEntityRepository = interestEntityRepository;
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getValues(@RequestParam String userName){
        UserEntity userEntity = userEntityRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException(userName + " was not found in database"));
        List<AddressEntity> addressEntities = addressEntityRepository.findAddressEntitiesByUserEntity(userEntity).orElseThrow(() -> new AddressNotFoundException("Address was not found for " + userEntity.getName()));
        List<Address> addresses = new ArrayList<>();
        addressEntities.forEach(addressEntity -> {
            Address address = Address.builder()
                    .flatOrHouseNumber(addressEntity.getFlatOrHouseNumber())
                    .streetName(addressEntity.getStreetName())
                    .areaName(addressEntity.getAreaName())
                    .cityName(addressEntity.getCityName())
                    .districtName(addressEntity.getDistrictName())
                    .stateName(addressEntity.getStateName())
                    .pincode(addressEntity.getPincode())
                    .build();
            addresses.add(address);
        });
        Set<Interest> interests = new HashSet<>();
        userEntity.getInterests().forEach(interestEntity -> {
            Interest interest = Interest.builder()
                    .name(interestEntity.getName())
                    .build();
            interests.add(interest);
        });
        User user = User.builder()
                .name(userEntity.getName())
                .age(userEntity.getAge())
                .gender(userEntity.getGender())
                .address(addresses)
                .interests(interests)
                .build();
        log.info("User: {}", user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        log.info("User: {}", user);
        List<AddressEntity> addressEntities = new ArrayList<>();
        Set<InterestEntity> interestEntitySet = new HashSet<>();
        user.getInterests().forEach( interest -> {
            InterestEntity interestEntity = interestEntityRepository.findByName(interest.getName()).orElseThrow(() -> new InterestNotFoundException(interest.getName() + " was not found"));
            interestEntitySet.add(interestEntity);
        });
        UserEntity userEntity = UserEntity.builder()
                .age(user.getAge())
                .name(user.getName())
                .gender(user.getGender())
                .interests(interestEntitySet)
                .build();
        user.getAddress().forEach(address -> {
            AddressEntity addressEntity = AddressEntity.builder()
                    .flatOrHouseNumber(address.getFlatOrHouseNumber())
                    .streetName(address.getStreetName())
                    .areaName(address.getAreaName())
                    .cityName(address.getCityName())
                    .districtName(address.getDistrictName())
                    .stateName(address.getStateName())
                    .pincode(address.getPincode())
                    .userEntity(userEntity)
                    .build();
            addressEntities.add(addressEntity);
        });


        userEntityRepository.save(userEntity);
        addressEntityRepository.saveAll(addressEntities);
        return "Details have been added";
    }

}
