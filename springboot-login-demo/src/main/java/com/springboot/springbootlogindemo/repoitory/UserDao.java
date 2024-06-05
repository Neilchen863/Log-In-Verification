package com.springboot.springbootlogindemo.repoitory;

import com.springboot.springbootlogindemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUname(String uname); // Find user by username (uname), note to use camelCase as per JPA format
    User findByUnameAndPassword(String uname, String password); // Find user by username (uname) and password
}
