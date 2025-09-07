package com.techhub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyModel {
	private WardModel wardModel = new WardModel();
	private int pId;
	private String pName;
	private String pAddress;
	private int pPrice;
	private int area_sqfeet;

}
