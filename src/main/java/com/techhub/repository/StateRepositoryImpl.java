package com.techhub.repository;

import java.sql.SQLException;
import java.util.*;

import com.techhub.model.StateModel;

import customeException.StateNotFoundException;

public class StateRepositoryImpl extends DBState implements StateRepository {

	@Override
	public boolean isAddnewState(StateModel model) {
		try {
			stmt = conn.prepareStatement(Query.addNewState);
			stmt.setString(1, model.getStateName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<StateModel> getAllStates() {
		List<StateModel> list = new ArrayList<StateModel>();
		try {
			stmt = conn.prepareStatement(Query.getAllStates);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new StateModel(rs.getInt(1), rs.getString(2)));
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public StateModel getStateByName(String stateName) {
		try {
			stmt = conn.prepareStatement(Query.getStateByName);
			stmt.setString(1, stateName);
			rs = stmt.executeQuery();
			if (rs.next())
				return new StateModel(rs.getInt(1), rs.getString(2));
			else
				throw new StateNotFoundException("State not found exception " + stateName);
		} catch (SQLException e) {
			System.out.println("Error is " + e);
			return null;
		} catch (StateNotFoundException snfe) {
			System.out.println("Error is " + snfe);
			return null;
		}

	}

	@Override
	public int getStateIdbyName(String stateName) {
		try {
			stmt = conn.prepareStatement(Query.getStateIdByName);
			stmt.setString(1, stateName);
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
	public boolean isStateDelete(String stateName) {
		try {
			int stateId = this.getStateIdbyName(stateName);
			if (stateId != -1) {
				stmt = conn.prepareStatement(Query.deleteState);
				stmt.setInt(1, stateId);
				int value = stmt.executeUpdate();
				return value > 0 ? true : false;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isUpdateState(String oldName, String newName) {
		try {
			int stateId = this.getStateIdbyName(oldName);
			stmt = conn.prepareStatement("update statemaster set statename=? where statename=?");
			stmt.setString(1, newName);
			stmt.setString(2, oldName);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getStateIdByCityName(String cityName) {
		try {
			stmt = conn.prepareStatement(Query.getStateIdByCityName);
			stmt.setString(1, cityName);
			rs = stmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			else
				return -1;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}
}
