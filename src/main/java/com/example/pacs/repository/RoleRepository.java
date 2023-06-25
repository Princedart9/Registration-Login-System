package com.example.pacs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacs.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
