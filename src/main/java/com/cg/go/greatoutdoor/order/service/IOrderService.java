package com.cg.go.greatoutdoor.order.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.go.greatoutdoor.order.entity.OrderEntity;
public interface IOrderService {

	public List<OrderEntity> findAllOrders();

	public List<OrderEntity> findOrdersByUserId(Integer userId);

	public OrderEntity addOrder(OrderEntity orderEntity);

	public void deleteAllOrders();

	public void deleteOrderById(Integer orderId);

	public void updateDate(Integer orderId, LocalDate dispatchDate, LocalDate arrivalDate);

	

}
