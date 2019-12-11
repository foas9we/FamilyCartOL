package com.briup.app.estore.bean;

import java.util.Date;

public class Order {
    private Integer id;

    private Double cost;

    private Date orderdate;

    private Customer customer;

    public Order() {}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate + ", customer=" + customer + "]";
	}

   
}