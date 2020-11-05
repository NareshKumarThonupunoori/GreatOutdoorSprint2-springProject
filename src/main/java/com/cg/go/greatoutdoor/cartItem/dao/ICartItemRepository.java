package com.cg.go.greatoutdoor.cartItem.dao;

import org.springframework.stereotype.Repository;

import com.cg.go.greatoutdoor.cartItem.entity.CartItemEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ICartItemRepository extends JpaRepository<CartItemEntity,Integer>{
	@Query(" from CartItemEntity where userId=:userId")
	List<CartItemEntity> findByUserId(@Param("userId") Integer userId);
	
}
