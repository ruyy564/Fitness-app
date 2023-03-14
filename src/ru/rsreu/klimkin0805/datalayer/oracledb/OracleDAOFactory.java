package ru.rsreu.klimkin0805.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.CustomerDAO;
import ru.rsreu.klimkin0805.datalayer.DAOFactory;
import ru.rsreu.klimkin0805.datalayer.GoodDAO;
import ru.rsreu.klimkin0805.datalayer.OrderDAO;

public class OracleDAOFactory extends DAOFactory {
	private static volatile OracleDAOFactory instance;
	private Connection connection;

	private OracleDAOFactory() {
	}

	public static OracleDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDAOFactory.class) {
				factory = new OracleDAOFactory();
				instance = factory;
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		Class.forName(Resourcer.getString("oracle"));
		String url = Resourcer.getString("url");
		String user = Resourcer.getString("user");
		String password = Resourcer.getString("pwd");
		connection = DriverManager.getConnection(url, user, password);
	}

	@Override
	public GoodDAO getGoodDAO() {
		return new OracleGoodDAO(connection);
	}

	@Override
	public OrderDAO getOrderDAO() {
		return new OracleOrderDAO(connection);
	}

	@Override
	public CustomerDAO getCustomerDAO() {
		return new OracleCustomerDAO(connection);
	}

}
