package ru.rsreu.klimkin0805.datalayer;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract GoodDAO getGoodDAO();

	public abstract OrderDAO getOrderDAO();

	public abstract CustomerDAO getCustomerDAO();
}
