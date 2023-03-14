package ru.rsreu.klimkin0805.datalayer.data;

import java.sql.Timestamp;

import com.prutzkow.resourcer.Resourcer;

public class Order {
	private String customer;
	private String good;
	private int quantity;
	private Timestamp date;

	public Order(String customer, String good, int quantity, Timestamp date) {
		this.customer = customer;
		this.good = good;
		this.quantity = quantity;
		this.date = date;
	}

	public String toString() {
		return String.format(Resourcer.getString("order.format"), customer, good, quantity, date);
	}
}
