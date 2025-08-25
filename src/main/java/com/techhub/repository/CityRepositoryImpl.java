package com.techhub.repository;

import com.techhub.model.CityModel;
import com.techhub.service.*;

public class CityRepositoryImpl extends DBstate implements CityRepository {

	DistService distService = new DistServiceImpl();
	StateService stateService = new StateServiceImpl();

	@Override
	public boolean isAddNewCity(CityModel model) {
		try {
			cstmt = conn.prepareCall(Query.saveCity);
			cstmt.setString(1, model.getCityName());
			cstmt.setInt(2, model.getStateId());
			cstmt.setInt(3, model.getDistId());
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getCityidByCityName(String cityName) {
		// TODO Auto-generated method stub
		try {

			int distId = distService.getDistIdByCityName(cityName);
			int stateId = stateService.getStateIdByCityName(cityName);

			stmt = conn.prepareStatement(Query.getCityIdByName);
			stmt.setString(1, cityName);
			stmt.setInt(2, stateId);
			stmt.setInt(3, distId);
			rs = stmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			else
				return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
