package com.techhub.model;

public class StateModel {
	private int stateId;
	private String stateName;

	public StateModel() {

	}

	public StateModel(int stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return stateId + "\t" + stateName;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		StateModel model = (StateModel) obj;
		if (model.getStateId() == this.stateId && model.getStateName().equals(this.stateName))
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return stateId * 10000;
	}
}
