package com.example.pacs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.pacs.models.UserInfo;

@Repository
@EnableJpaRepositories
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
	   // Name is a property of Employee class
	//@Query("select name, role, password,email from UserInfo where name=?1")
    public UserInfo findByName(String useName); 
    
        // Dummy is not a property of Employee class
    //to use this Method Need to declare private String dummy; in UserInfo
   // public List<UserInfo> findByDummy(String userName);

}
