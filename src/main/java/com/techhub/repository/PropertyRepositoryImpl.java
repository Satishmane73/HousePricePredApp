package com.techhub.repository;

import java.util.List;

import com.techhub.model.AminityModel;
import com.techhub.model.PropertyModel;
import com.techhub.model.WardModel;

public class PropertyRepositoryImpl extends DBState implements PropertyRepository {

	@Override
	public boolean isAddNewProperty(PropertyModel model) {
		WardModel wModel = model.getModel();
		int wardId = wModel.getWardId();
		int pId = model.getPId();
		String pName = model.getPName();
		String pAdd = model.getPAddress();
		int area = model.getArea_sqfeet();
		int pPrice = model.getPPrice();
		System.out.println();
		System.out.println(pId + "\t" + pName + "\t" + pAdd + "\t" + area + "\t" + pPrice + "\t" + wardId);
		System.out.println();

		List<AminityModel> aminityList = model.getList();
		for (AminityModel aminityModel : aminityList) {
			System.out.println(aminityModel.getAminity_Id() + "\t" + pId + "\t" + aminityModel.getPrice());
			pPrice = pPrice + aminityModel.getPrice();
		}
		System.out.println("total Price " + pPrice);

		return false;
	}

}
