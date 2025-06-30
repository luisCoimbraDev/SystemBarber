package com.example.barbearia.repository;

import com.example.barbearia.model.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {
    public UserSystem findByloginuser(String login_user);

    public UserSystem findById(long id);


}
