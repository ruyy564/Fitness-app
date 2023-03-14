package ru.rsreu.klimkin0805.datalayer;

import java.util.List;

import ru.rsreu.klimkin0805.datalayer.data.Order;

public interface OrderDAO {
	List<Order> getListOrdersForPeriodTime(String firstDate, String secondDate);
}
