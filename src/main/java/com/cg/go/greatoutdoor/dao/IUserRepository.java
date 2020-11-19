package com.cg.go.greatoutdoor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.go.greatoutdoor.entity.Userdata;
@EnableJpaRepositories
@Repository
public interface IUserRepository extends JpaRepository<Userdata,Integer>{

	@Query("SELECT u FROM Userdata u WHERE u.userName = :username")
	public Userdata findByUserName(@Param("username") String username);


}