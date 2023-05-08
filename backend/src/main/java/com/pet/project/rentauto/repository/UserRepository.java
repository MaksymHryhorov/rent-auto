package com.pet.project.rentauto.repository;

import com.pet.project.rentauto.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findBySub(String sub);
}

