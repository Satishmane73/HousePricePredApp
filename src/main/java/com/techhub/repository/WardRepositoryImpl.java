package com.techhub.repository;

import com.techhub.model.*;
import com.techhub.service.*;

public class WardRepositoryImpl extends DBState implements WardRepository {

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

}
