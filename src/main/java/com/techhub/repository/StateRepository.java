package com.techhub.repository;

import java.util.*;

import com.techhub.model.StateModel;

public interface StateRepository {
	public boolean isAddnewState(StateModel model);

	public List<StateModel> getAllStates();

	public StateModel getStateByName(String stateName);

	public int getStateIdbyName(String stateName);

	public boolean isStateDelete(String stateName);

	public boolean isUpdateState(String oldName, String newName);
	
	public int getStateIdByCityName(String cityName);

}
