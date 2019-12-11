package com.briup.app.estore.bean;

public class Orderline {
    private Integer id;

    private Integer num;

    private Integer orderId;

    private Book book;
    
    public Orderline() {}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Orderline [id=" + id + ", num=" + num + ", orderId=" + orderId + ", book=" + book + "]";
	}

	public Orderline(Integer id, Integer num, Integer orderId, Book book) {
		super();
		this.id = id;
		this.num = num;
		this.orderId = orderId;
		this.book = book;
	}
    
}