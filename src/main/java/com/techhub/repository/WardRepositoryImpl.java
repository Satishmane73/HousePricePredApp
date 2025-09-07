package com.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import com.techhub.model.*;
import com.techhub.service.*;

public class WardRepositoryImpl extends DBState implements WardRepository {

	List<WardModel> wardList;

	@Override
	public boolean isAddNewWard(WardModel wardModel, int cityId) {
		try {
			cstmt = conn.prepareCall(Query.addNewWard);
			cstmt.setString(1, wardModel.getWardName());
			cstmt.setInt(2, wardModel.getPin());
			cstmt.setInt(3, cityId);
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<WardModel> getAllWardByCityName(String cityName) {
		try {
			wardList = new ArrayList<WardModel>();
			stmt = conn.prepareStatement(Query.getWardByCityName);
			stmt.setString(1, cityName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				wardList.add(new WardModel(rs.getString(1)));
			}
			return wardList.size() > 0 ? wardList : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getWardIdByName(String wardName) {
		try {
			stmt = conn.prepareStatement(Query.getWardIdByName);
			stmt.setString(1, wardName);
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
