package com.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import com.techhub.model.CityModel;
import com.techhub.service.*;

public class CityRepositoryImpl extends DBState implements CityRepository {

	DistService distService = new DistServiceImpl();
	StateService stateService = new StateServiceImpl();

	List<CityModel> cityList;

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

	@Override
	public List<CityModel> getCitiesFromDist(String stateName, String distName) {
		// TODO Auto-generated method stub
		cityList = new ArrayList<CityModel>();
		try {
			int stateId = stateService.getStateIdbyName(stateName);
			int distId = distService.getDistIdByDistName(distName);
			stmt = conn.prepareStatement(Query.getCityByDistId);
			stmt.setInt(1, stateId);
			stmt.setInt(2, distId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cityList.add(new CityModel(rs.getInt(2), rs.getString(1)));
			}
			return cityList.size() > 0 ? cityList : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
