package ru.rsreu.klimkin0805.datalayer;

import java.sql.SQLException;

import ru.rsreu.klimkin0805.datalayer.oracledb.OracleDAOFactory;

public enum DBType {

	ORACLE {
		@Override
		public DAOFactory getDAOFactory() {
			DAOFactory oracleDAOFactory = null;
			try {
				oracleDAOFactory = OracleDAOFactory.getInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return oracleDAOFactory;
		}
	};

	public static DBType getTypeByName(String dbType) {
		try {
			return DBType.valueOf(dbType.toUpperCase());
		} catch (Exception e) {
			throw new DBTypeException();
		}
	}

	public abstract DAOFactory getDAOFactory();

}
