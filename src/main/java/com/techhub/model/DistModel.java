package com.techhub.model;

public class DistModel extends StateModel {
	private int distId;
	private String distName;

	public DistModel() {
	}

	public DistModel(int distId, String DistName) {
		this.distId = distId;
		this.distName = DistName;
	}

	public int getDistId() {
		return distId;
	}

	public void setDistId(int distId) {
		this.distId = distId;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	@Override
	public String toString() {
		return distId + "\t" + distName;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		DistModel model = (DistModel) obj;

		if (model.getDistId() == this.distId && model.getDistName().equals(this.distName))
			return true;
		else
			return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return distId * 10000;
	}
}
