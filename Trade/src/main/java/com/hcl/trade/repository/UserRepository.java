package com.hcl.trade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
