package com.vmd.restfuljavaserver.repos;

import org.springframework.stereotype.Repository;

import com.vmd.restfuljavaserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);

    public User findByEmail(String email);
}
