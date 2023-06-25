package com.example.pacs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacs.models.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

}
