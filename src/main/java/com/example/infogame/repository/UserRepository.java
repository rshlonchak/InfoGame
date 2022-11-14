package com.example.infogame.repository;

import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.models.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT * FROM users")
    List<UserResponseDto> listUsers();

    @Query("SELECT * FROM users WHERE id=:itemId")
    Optional<User> getUserById(int itemId);

    @Modifying
    @Query("UPDATE users SET name=:name WHERE id=:itemId")
    void renameUser(int itemId, String name);
}
