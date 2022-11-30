package icu.internetcomputation.scarboroughfair;

import org.springframework.data.repository.CrudRepository;

import icu.internetcomputation.scarboroughfair.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
