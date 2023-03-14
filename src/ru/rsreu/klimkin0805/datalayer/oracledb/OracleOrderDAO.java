package ru.rsreu.klimkin0805.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.OrderDAO;
import ru.rsreu.klimkin0805.datalayer.data.Order;

public class OracleOrderDAO implements OrderDAO {
	private static final int FIELD_CUSTOMER = 2;
	private static final int FIELD_GOOD = 3;
	private static final int FIELD_QUANTITY = 4;
	private static final int FIELD_DATE = 5;
	private Connection connection;

	public OracleOrderDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Order> getListOrdersForPeriodTime(String firstDate, String secondDate) {
		List<Order> listOrdersForPeriodTime = new ArrayList<>();
		try {
			String sql = Resourcer.getString("sql.query.get.all.list.orders.for.period.time");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, firstDate);
			statement.setString(2, secondDate);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order(resultSet.getString(FIELD_CUSTOMER), resultSet.getString(FIELD_GOOD),
						resultSet.getInt(FIELD_QUANTITY), resultSet.getTimestamp(FIELD_DATE));
				listOrdersForPeriodTime.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOrdersForPeriodTime;
	}

}
