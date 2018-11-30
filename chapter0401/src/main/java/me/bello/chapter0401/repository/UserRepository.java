package me.bello.chapter0401.repository;

import me.bello.chapter0401.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
