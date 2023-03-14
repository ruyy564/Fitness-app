package ru.rsreu.klimkin0805.datalayer.data;

import com.prutzkow.resourcer.Resourcer;

public class Good {
	private double price;
	private String unit;
	private String description;

	public Good(double price, String unit, String description) {
		this.price = price;
		this.unit = unit;
		this.description = description;
	}

	public String getDescription() {
		return description;

	}

	public String toString() {
		return String.format(Resourcer.getString("good.format"), price, unit, description);
	}

}
