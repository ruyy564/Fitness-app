package ru.rsreu.klimkin0805.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.CustomerDAO;
import ru.rsreu.klimkin0805.datalayer.data.Customer;

public class OracleCustomerDAO implements CustomerDAO {
	private static final int FIELD_NAME = 2;
	private static final int FIELD_ADDRESS = 3;
	private static final int FIELD_PHONE = 4;
	private static final int FIELD_SURNAME_CONTACT_PERSON = 5;
	private static final int FIELD_QUANTITY_GOODS= 6;
	private Connection connection;

	public OracleCustomerDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Customer> getListCustomersForGivenGood(String goodDescription) {
		List<Customer> listCustomersForGivenGood = new ArrayList<>();
		try {
			String sql = Resourcer.getString("sql.query.get.list.customers.for.given.good");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, goodDescription);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getString(FIELD_NAME), resultSet.getString(FIELD_ADDRESS),
						resultSet.getString(FIELD_PHONE), resultSet.getString(FIELD_SURNAME_CONTACT_PERSON));
				listCustomersForGivenGood.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCustomersForGivenGood;
	}

	@Override
	public Map<Customer, Integer> getQuantityOrdersByCustomer() {
		Map<Customer, Integer> mapQuantityOrdersByCustomer = new HashMap<Customer, Integer>();
		try {
			String sql = Resourcer.getString("sql.query.get.quantity.orders.by.customer");
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getString(FIELD_NAME), resultSet.getString(FIELD_ADDRESS),
						resultSet.getString(FIELD_PHONE), resultSet.getString(FIELD_SURNAME_CONTACT_PERSON));
				mapQuantityOrdersByCustomer.put(customer, resultSet.getInt(FIELD_QUANTITY_GOODS));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapQuantityOrdersByCustomer;
	}
}
