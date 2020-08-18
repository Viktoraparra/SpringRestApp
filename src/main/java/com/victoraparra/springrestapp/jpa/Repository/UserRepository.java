package com.victoraparra.springrestapp.jpa.Repository;

import com.victoraparra.springrestapp.jpa.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
