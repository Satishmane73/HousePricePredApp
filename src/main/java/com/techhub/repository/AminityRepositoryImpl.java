package com.techhub.repository;

import org.apache.log4j.Logger;

import com.techhub.clientApp.ClientApp;
import com.techhub.model.AminityModel;

public class AminityRepositoryImpl extends DBState implements AminityRepository {

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

}
