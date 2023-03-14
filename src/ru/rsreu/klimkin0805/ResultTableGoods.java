package ru.rsreu.klimkin0805;

import java.util.List;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.klimkin0805.datalayer.data.Good;

public class ResultTableGoods {
	private static final int FIELD_PRICE = 0;
	private static final int FIELD_UNIT = 1;
	private static final int FIELD_DESCRIPTION = 2;

	private ResultTableGoods() {

	}

	public static String getTable(List<Good> listGoods) {
		StringBuilder resultString = new StringBuilder();
		resultString.append(
				String.format(Resourcer.getString("table.format.goods"), Resourcer.getString("good.description"),
						Resourcer.getString("good.price"), Resourcer.getString("good.unit")));
		for (Good goods : listGoods) {
			String[] parametrsObject = goods.toString().trim().split("\t");
			resultString.append(String.format(Resourcer.getString("table.format.goods"), parametrsObject[FIELD_DESCRIPTION],
					parametrsObject[FIELD_PRICE], parametrsObject[FIELD_UNIT]));
		}
		return resultString.toString();

	}
}
