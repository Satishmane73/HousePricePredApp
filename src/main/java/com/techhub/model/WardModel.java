package com.techhub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WardModel extends CityModel {
	private int wardId;
	private String wardName;
	private int pin;

	public WardModel(String wardName) {
		this.wardName = wardName;
	}

}
