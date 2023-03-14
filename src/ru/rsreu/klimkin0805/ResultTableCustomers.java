package ru.rsreu.klimkin0805;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.data.Customer;

public class ResultTableCustomers {
	private static final int FIELD_NAME = 0;
	private static final int FIELD_ADDRESS = 1;
	private static final int FIELD_PHONE = 2;
	private static final int FIELD_SURNAME_CONTACT_PERSON = 3;

	private ResultTableCustomers() {

	}

	public static String getTable(List<Customer> listCustomer) {
		StringBuilder resultString = new StringBuilder();
		resultString.append(String.format(Resourcer.getString("table.format.customers"),
				Resourcer.getString("customer.name"), Resourcer.getString("customer.address"),
				Resourcer.getString("customer.phone"), Resourcer.getString("customer.fam")));
		for (Customer customer : listCustomer) {
			String[] parametrsObject = customer.toString().trim().split("\t");
			resultString.append(String.format(Resourcer.getString("table.format.customers"),
					parametrsObject[FIELD_NAME], parametrsObject[FIELD_ADDRESS], parametrsObject[FIELD_PHONE],
					parametrsObject[FIELD_SURNAME_CONTACT_PERSON]));
		}
		return resultString.toString();

	}

	public static String getTable(Map<Customer, Integer> mapCustomer) {
		StringBuilder resultString = new StringBuilder();
		resultString.append(
				String.format(Resourcer.getString("table.format.customers.map"), Resourcer.getString("customer.name"),
						Resourcer.getString("customer.address"), Resourcer.getString("customer.phone"),
						Resourcer.getString("customer.fam"), Resourcer.getString("customer.value")));
		Iterator<Customer> iterator = mapCustomer.keySet().iterator();
		while (iterator.hasNext()) {
			Customer key = iterator.next();
			String[] parametrsObject = key.toString().trim().split("\t");
			int value = mapCustomer.get(key);
			resultString.append(String.format(Resourcer.getString("table.format.customers.map"),
					parametrsObject[FIELD_NAME], parametrsObject[FIELD_ADDRESS], parametrsObject[FIELD_PHONE],
					parametrsObject[FIELD_SURNAME_CONTACT_PERSON], value));
		}
		return resultString.toString();

	}
}
