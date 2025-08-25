package com.techhub.service;

import java.util.List;

import com.techhub.model.StateModel;
import com.techhub.repository.*;

public class StateServiceImpl implements StateService {
	StateRepository repo = new StateRepositoryImpl();

	@Override
	public boolean isAddnewState(StateModel model) {
		// TODO Auto-generated method stub
		return repo.isAddnewState(model);
	}

	@Override
	public List<StateModel> getAllStates() {

		return repo.getAllStates();
	}

	@Override
	public StateModel getStateByName(String stateName) {

		return repo.getStateByName(stateName);
	}

	@Override
	public boolean isStateDelete(String stateName) {
		// TODO Auto-generated method stub
		return repo.isStateDelete(stateName);
	}

	@Override
	public boolean isUpdateState(String oldName, String newName) {
		// TODO Auto-generated method stub
		return repo.isUpdateState(oldName, newName);
	}

	@Override
	public int getStateIdbyName(String stateName) {
		// TODO Auto-generated method stub
		return repo.getStateIdbyName(stateName);
	}

	@Override
	public int getStateIdByCityName(String cityName) {
		// TODO Auto-generated method stub
		return repo.getStateIdByCityName(cityName);
	}

}
