package ru.rsreu.klimkin0805;

import java.util.List;

import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.klimkin0805.datalayer.data.Order;

public class ResultTableOrders {
	private static final int FIELD_CUSTOMER = 0;
	private static final int FIELD_GOOD = 1;
	private static final int FIELD_QUANTITY = 2;
	private static final int FIELD_DATE = 3;

	private ResultTableOrders() {

	}

	public static String getTable(List<Order> listOrder) {
		StringBuilder resultString = new StringBuilder();
		resultString.append(String.format(Resourcer.getString("table.format.orders"),Resourcer.getString("order.customer") ,
				Resourcer.getString("order.good"), Resourcer.getString("order.quantity"),
				Resourcer.getString("order.date")));
		for (Order customer : listOrder) {
			String[] parametrsObject = customer.toString().trim().split("\t");
			resultString.append(String.format(Resourcer.getString("table.format.orders"), parametrsObject[FIELD_CUSTOMER],
					parametrsObject[FIELD_GOOD], parametrsObject[FIELD_QUANTITY], parametrsObject[FIELD_DATE]));
		}
		return resultString.toString();

	}
}
