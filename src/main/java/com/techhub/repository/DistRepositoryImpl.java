
//this class for implementing all operation  related to the district 

package com.techhub.repository;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import com.techhub.model.DistModel;

import customeException.StateNotFoundException;

public class DistRepositoryImpl extends DBState implements DistRepository {

	// this method for save a specific only one district at time in database

	@Override
	public boolean isAddNewDist(String stateName, String distName) {
		// TODO Auto-generated method stub
		try {
			cstmt = conn.prepareCall(Query.savedist);
			cstmt.setString(1, stateName);
			cstmt.setString(2, distName);
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// this method for save tow or more district at a time in database by using file
	// handling

	@Override
	public boolean isAddBulkDist(String stateName) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			FileReader fr = new FileReader("D:\\Project\\HousePrisePredApp\\src\\main\\java\\txtfiles\\MahaDists.txt");
			BufferedReader br = new BufferedReader(fr);
			String distName;
			while ((distName = br.readLine()) != null) {
				cstmt = conn.prepareCall(Query.savedist);
				cstmt.setString(1, stateName);
				cstmt.setString(2, distName);
				b = cstmt.execute();
			}
			return !b;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// this method return list of district witch is available in out database
	// using List collection

	@Override
	public List<DistModel> getDistListByStateName(String stateName) {
		// TODO Auto-generated method stub
		List<DistModel> distList = new ArrayList<DistModel>();
		try {
			stmt = conn.prepareStatement(Query.getDistByStateName);
			stmt.setString(1, stateName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DistModel model = new DistModel(rs.getInt(1), rs.getString(2));
				distList.add(model);
			}
			if (distList.size() > 0)
				return distList;
			else
				throw new StateNotFoundException(stateName);
		} catch (SQLException e) {
			return null;
		} catch (StateNotFoundException snfe) {
//			System.out.println(snfe.getMessage());
			return null;
		}
	}

	// this method return district id by district name

	@Override
	public int getDistIdByDistName(String distName) {
		// TODO Auto-generated method stub

		try {
			stmt = conn.prepareStatement(Query.getDistIdByName);
			stmt.setString(1, distName);
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

	// this method return district id from city name

	@Override
	public int getDistIdByCityName(String cityName) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement(Query.getDistIdByCityName);
			stmt.setString(1, cityName);
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
