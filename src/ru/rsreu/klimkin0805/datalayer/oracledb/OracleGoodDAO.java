package ru.rsreu.klimkin0805.datalayer.oracledb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.GoodDAO;
import ru.rsreu.klimkin0805.datalayer.data.Good;

public class OracleGoodDAO implements GoodDAO {
	private static final int FIELD_PRICE = 2;
	private static final int FIELD_UNIT = 3;
	private static final int FIELD_DESCRIPTION = 4;
	private Connection connection;

	public OracleGoodDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Good> getAllListGoods() {
		List<Good> listGoods = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String sql = Resourcer.getString("sql.query.get.all.list.goods");
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Good good = new Good(resultSet.getDouble(FIELD_PRICE), resultSet.getString(FIELD_UNIT),
						resultSet.getString(FIELD_DESCRIPTION));
				listGoods.add(good);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listGoods;
	}

}
