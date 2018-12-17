package com.example.easynotes.auth;

import com.example.easynotes.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
//@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080","file://*"})
@CrossOrigin
public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUsername(String username);
}