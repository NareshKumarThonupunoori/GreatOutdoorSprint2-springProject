package com.cg.go.greatoutdoor.order.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.go.greatoutdoor.order.entity.OrderEntity;

public interface IOrderRepository extends JpaRepository<OrderEntity,Integer>{
	public List<OrderEntity> findOrdersByUserId(Integer userId);
	public List<OrderEntity> findAllOrders();
	public OrderEntity addOrder(OrderEntity orderEntity) ;
	public void deleteAllOrders() ;
	public void deleteOrderById(String orderId);
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate);
}
