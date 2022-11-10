package com.example.infogame.repository;

import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT * FROM users")
    List<UserResponseDto> listUsers();
}
