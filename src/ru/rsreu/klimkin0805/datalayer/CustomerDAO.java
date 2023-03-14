package ru.rsreu.klimkin0805.datalayer;

import java.util.List;
import java.util.Map;

import ru.rsreu.klimkin0805.datalayer.data.Customer;

public interface CustomerDAO {
	List<Customer> getListCustomersForGivenGood(String goodDescription);

	Map<Customer, Integer> getQuantityOrdersByCustomer();
}
