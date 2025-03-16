package com.shashi.springsecurity.repository;

// create a repository interface UserInfoRepository which extends JpaRepository for UserInfo entity.
import com.shashi.springsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    // Define a method findByName() to find a user by name.
    Optional<UserInfo> findByName(String name);
}


