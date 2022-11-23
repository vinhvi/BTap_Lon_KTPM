package com.example.userService.repo;

import com.example.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findUserById(Long userId);

    @Query(value = "select * from t_user where email = :email", nativeQuery = true)
     List<User> login(@Param(value = "email") String email);

}
