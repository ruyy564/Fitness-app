package ru.rsreu.klimkin0805;

import java.util.List;
import java.util.Map;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.CustomerDAO;
import ru.rsreu.klimkin0805.datalayer.DAOFactory;
import ru.rsreu.klimkin0805.datalayer.DBType;
import ru.rsreu.klimkin0805.datalayer.DBTypeException;
import ru.rsreu.klimkin0805.datalayer.GoodDAO;
import ru.rsreu.klimkin0805.datalayer.OrderDAO;
import ru.rsreu.klimkin0805.datalayer.data.Customer;
import ru.rsreu.klimkin0805.datalayer.data.Good;
import ru.rsreu.klimkin0805.datalayer.data.Order;

public class Runner {

	private Runner() {

	}

	public static void main(String[] args) {
		StringBuilder resultString = new StringBuilder();
		DAOFactory factory = null;
		GoodDAO goodDAO = null;
		OrderDAO orderDAO = null;
		CustomerDAO customerDAO = null;
		try {
			factory = DAOFactory.getInstance(DBType.ORACLE);
			goodDAO = factory.getGoodDAO();
			orderDAO = factory.getOrderDAO();
			customerDAO = factory.getCustomerDAO();
		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		String firstDate = Resourcer.getString("first.date");
		String secondDate = Resourcer.getString("second.date");
		List<Good> listGood = goodDAO.getAllListGoods();
		String descriptionGood = listGood.get(2).getDescription();
		List<Order> listOrdersForPeriodTime = orderDAO.getListOrdersForPeriodTime(firstDate, secondDate);
		List<Customer> listCustomerForGivenGood = customerDAO.getListCustomersForGivenGood(descriptionGood);
		Map<Customer,Integer> mapQuantityOrdersByCustomer = customerDAO.getQuantityOrdersByCustomer();
		resultString.append(Resourcer.getString("sql.query.1")).append(firstDate).append("\t").append(secondDate)
				.append("\n")
				.append(ResultTableOrders.getTable(listOrdersForPeriodTime))
				.append("\n").append(Resourcer.getString("sql.query.3")).append("\t").append(descriptionGood)
				.append("\n")
				.append(ResultTableCustomers.getTable(listCustomerForGivenGood))
				.append("\n").append(Resourcer.getString("sql.query.2")).append("\n")
				.append(ResultTableCustomers.getTable(mapQuantityOrdersByCustomer));
		System.out.println(resultString);
	}

}
