package com.cg.go.greatoutdoor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.go.greatoutdoor.entity.Userdata;

public interface IUserRepository extends JpaRepository<Userdata,Integer>{

}