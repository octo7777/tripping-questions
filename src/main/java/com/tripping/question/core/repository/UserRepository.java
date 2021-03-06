package com.tripping.question.core.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tripping.question.core.domain.User;

/**
 * Created by piotrok on 8/27/14.
 */
@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    List<User> findByEmail(String email);
    List<User> findByName(String name);
}
