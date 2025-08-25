//this interface for declare operations of destrict which is implemented in DistRepositoryImpl class 

package com.techhub.repository;

import java.util.List;

import com.techhub.model.DistModel;

public interface DistRepository {

	public boolean isAddNewDist(String stateName, String distName);

	public boolean isAddBulkDist(String stateName);

	public List<DistModel> getDistListByStateName(String stateName);

	public int getDistIdByDistName(String distName);

	public int getDistIdByCityName(String cityName);
}
