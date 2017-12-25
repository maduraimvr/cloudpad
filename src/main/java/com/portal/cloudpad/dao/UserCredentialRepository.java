package com.portal.cloudpad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.cloudpad.dto.User;

@Repository
public interface UserCredentialRepository extends JpaRepository<User, String> {

    
}