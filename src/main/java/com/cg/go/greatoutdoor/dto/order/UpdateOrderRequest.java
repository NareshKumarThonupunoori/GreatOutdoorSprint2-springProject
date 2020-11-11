package com.cg.go.greatoutdoor.dto.order;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.ElementCollection;

public class UpdateOrderRequest {
	private Integer orderId;
	private Integer userId;	
	@ElementCollection
	private Map<Integer,Integer> products; // productIds,Quantity
	private LocalDate dispatchDate;
	private LocalDate deliveryDate;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Map<Integer, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Integer, Integer> products) {
		this.products = products;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
