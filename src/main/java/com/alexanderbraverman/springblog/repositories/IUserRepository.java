package com.alexanderbraverman.springblog.repositories;

import com.alexanderbraverman.springblog.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Users, Long> {
}
