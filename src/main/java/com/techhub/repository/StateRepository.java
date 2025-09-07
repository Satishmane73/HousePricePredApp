package com.techhub.repository;

import java.util.*;

import com.techhub.model.StateModel;

public interface StateRepository {
	boolean isAddnewState(StateModel model);

	List<StateModel> getAllStates();

	StateModel getStateByName(String stateName);

	int getStateIdbyName(String stateName);

	boolean isStateDelete(String stateName);

	boolean isUpdateState(String oldName, String newName);

	int getStateIdByCityName(String cityName);

}
