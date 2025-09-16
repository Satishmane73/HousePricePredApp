package com.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.techhub.clientApp.ClientApp;
import com.techhub.model.AminityModel;

public class AminityRepositoryImpl extends DBState implements AminityRepository {

	List<AminityModel> list;

	@Override
	public boolean isAddNewAminity(AminityModel model) {
		try {
			stmt = conn.prepareStatement(Query.addNewAminity);
			stmt.setString(1, model.getAminity_Name());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AminityModel> getAllAminities() {
		try {
			list = new ArrayList<AminityModel>();
			stmt = conn.prepareStatement(Query.getAllAminities);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AminityModel model = new AminityModel();
				model.setAminity_Id(rs.getInt(1));
				model.setAminity_Name(rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
