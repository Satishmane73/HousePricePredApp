package com.techhub.service;

import java.util.List;

import com.techhub.model.StateModel;

public interface StateService {
	public boolean isAddnewState(StateModel model);

	public List<StateModel> getAllStates();

	public StateModel getStateByName(String stateName);

	public int getStateIdbyName(String stateName);

	public boolean isStateDelete(String stateName);

	public boolean isUpdateState(String oldName, String newName);

	public int getStateIdByCityName(String cityName);

}
