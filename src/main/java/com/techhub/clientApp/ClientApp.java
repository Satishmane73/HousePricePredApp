package com.techhub.clientApp;

import java.util.*;
import com.techhub.model.*;
import com.techhub.service.*;
import org.apache.log4j.*;

public class ClientApp {

	// This count is used for giving numbering to the list of state and district
	static int count;

	// Scanner class object to take inputs from user
	static Scanner scr = new Scanner(System.in);

	public static void main(String[] args) {

		StateService stateService = new StateServiceImpl();
		StateModel stateModel = new StateModel();

		DistService distService = new DistServiceImpl();
//		DistModel distModel = new DistModel();

		CityModel cityModel = new CityModel();
		CityService cityService = new CityServiceImpl();

		WardModel wardModel;
		WardService wardService = new WardServiceImpl();

		AminityService AminityService = new AminityServiceImpl();

		PropertyService propService = new PropertyServiceImpl();

		// this flag used to exit the application in case 9
		boolean flag = true;

		do {
			System.out.println();
			System.out.println("State related services press : 1");
			System.out.println("Dist related services press : 2");
			System.out.println("City related services press : 3");
			System.out.println("Ward related services press : 4");
			System.out.println("Aminity related services press : 5");
			System.out.println("Property related services press : 6");
			System.out.println("For exit press : 9");
			System.out.println();
			System.out.println("Enter Your Choice");
			int choice = -1;

			while (true) {
				try {
					choice = scr.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid input");
					scr.next();
				}
			} // while end
			switch (choice) {

// State ======================================================================================================			
			// this Case for All State Related Services
			case 1:
				boolean b;
				boolean exit = true;
				do {
					System.out.println();
					System.out.println("1 For Enter new state");
					System.out.println("2 For Display all state");
					System.out.println("3 For Search state by name");
					System.out.println("4 For Delete state by name");
					System.out.println("5 For Update state name");
					System.out.println("9 Exit");
					System.out.println();
					int ch = -1;
					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter valid Input");
							scr.next();

						}
					}
					switch (ch) {
					case 1:
						System.out.println("Enter State Name");
						scr.nextLine();
						b = stateService.isAddnewState(new StateModel(0, scr.nextLine()));
						if (b)
							System.out.println("State added Successfully\n");
						else
							System.out.println("Something went wrong\n");
						break;

					case 2:
						System.out.println();
						List<StateModel> list = stateService.getAllStates();
						if (list != null) {
							list.forEach((s) -> System.out.println(s.getStateId() + "\t" + s.getStateName()));
						} else {
							System.out.println("There is no data");
						}
						break;

					case 3:
						System.out.println("Enter State name to search");
						scr.nextLine();
						stateModel = stateService.getStateByName(scr.nextLine());
						if (stateModel != null) {
							System.out.println("State Found");
							System.out.println(stateModel.getStateId() + "\t" + stateModel.getStateName());
						} else
							System.out.println("State Not Found");
						break;

					case 4:
						System.out.println("Enter state name to delete");
						scr.nextLine();
						b = stateService.isStateDelete(scr.nextLine());
						if (b)
							System.out.println("State Deleted Successfully");
						else
							System.out.println("State Not Deleted");
						break;

					case 5:
						System.out.println("Enter state old name and new to update ");
						scr.nextLine();
						b = stateService.isUpdateState(scr.nextLine(), scr.nextLine());
						if (b)
							System.out.println("State updated Successfully");
						else
							System.out.println("State not updated");
						break;

					case 9:
						exit = false;
						break;
					default:
						System.out.println("Wrong input");
						break;
					}// case 1 switch block end

				} while (exit);// case 1 do while end
				break;// top level case 1 end

// District ===================================================================================================
			// This case for all District Related Services
			case 2:
				exit = true;
				do {
					System.out.println();
					System.out.println("1 : Add new dist");
					System.out.println("2 : Add Dists in Bulk");
					System.out.println("3 : Display all dists with state");
					System.out.println("4 : Display dist list by state name");
					System.out.println("9 Exit");
					System.out.println();
					int ch = -1;
					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException ime) {
							System.out.println("please enter a valid input");
							scr.next();
						}
					}
					switch (ch) {

					case 1:

						System.out.println("Enter state name in which you want to enter dist");
						scr.nextLine();
						String stateName = scr.nextLine();
						System.out.println("Enter dist name");
						String distName = scr.nextLine();
						b = distService.isAddNewDist(stateName, distName);
						if (b)
							System.out.println("Dist Entered in " + stateName + " State Successfully");
						else
							System.out.println("Something Went Wrong");

						break;

					case 2:

						System.out.println("Enter state name in which you want to enter dist");
						scr.nextLine();
						stateName = scr.nextLine();
						b = distService.isAddBulkDist(stateName);
						if (b)
							System.out.println("Dists Entered in " + stateName + " State Successfully");
						else
							System.out.println("Something Went Wrong");

						break;

					case 3:
						// this case for display state wise District list

						List<StateModel> stateList = stateService.getAllStates();
						for (int i = 0; i < stateList.size(); i++) {
							if (stateList != null && !stateList.isEmpty()) {
								StateModel s = stateList.get(i);
								stateName = s.getStateName();
//								System.out.println(stateName);
								System.out.println();
								System.out.println("Districts from state of " + stateName);
								System.out.println("----------------------------------------");
								List<DistModel> distList = distService.getDistListByStateName(stateName);
								if (distList != null) {
									count = 0;
									distList.forEach(
											(dist) -> System.out.println((++count) + "\t" + dist.getDistName()));
								} else {
									System.out.println("Districs not found in state of " + stateName);
								}
							}
						}
						break;

					case 4:
						// this case for display districts related to one state

						count = 0;
						System.out.println();
						List<StateModel> list = stateService.getAllStates();
						if (list != null) {
							list.forEach((s) -> System.out.println((++count) + "\t" + s.getStateName()));
							System.out.println("Enter state name to display district list");
							scr.nextLine();
							stateName = scr.nextLine();
							System.out.println("Districts from state of " + stateName);
							System.out.println("----------------------------------------");
							List<DistModel> distList = distService.getDistListByStateName(stateName);
							if (distList != null) {
								distList.forEach((dist) -> System.out.println(dist.getDistName()));
							} else {
//								System.out.println("Do you want to add this state in database");
//								String msg = scr.nextLine();
//								if (msg.equals("yes")) {
//									b = stateService.isAddnewState(new StateModel(0, stateName));
//									if (b)
//										System.out.println("New State Added Successfully");
//									else
//										System.out.println("Something went Wrong");
//								} else
//									System.out.println("No");
								System.out.println("Districs not found in state " + stateName);
							}
						} else {
							System.out.println("There is no data");
						}

						break;

					case 9:
						exit = false;
						break;
					}// switch
				} while (exit);// do while
				break;// case 2 District

// City ========================================================================================================
			// This Case for all City Related Services
			case 3:
				exit = true;
				do {
					int ch;
					System.out.println();
					System.out.println("1 : Add new City");
					System.out.println("9 : Exit");
					System.out.println();
					System.out.println("Enter your choice");

					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException ime) {
							System.out.println("Please enter valid input");
							scr.next();
						}
					} // while
					switch (ch) {

					case 1:
						System.out.println();
						System.out.println("Enter state name to add city");
						scr.nextLine();
						int stateId = stateService.getStateIdbyName(scr.nextLine());
						System.out.println("Enter dist name to add city");
						int distId = distService.getDistIdByDistName(scr.nextLine());

						System.out.println("Enter city name ");
						String cityName = scr.nextLine();

						cityModel.setDistId(distId);
						cityModel.setStateId(stateId);
						cityModel.setCityName(cityName);

						b = cityService.isAddNewCity(cityModel);
						if (b)
							System.out.println("City Added Succesfully");
						else
							System.out.println("Something Went Wrong");

						break; // case 1

					case 9:

						exit = false;

						break; // case 9

					}// switch
				} while (exit);// do while
				break;// Case 3 City
// Ward ========================================================================================================
			// This case for all ward related Services
			case 4:
				exit = true;
				do {
					System.out.println();
					System.out.println("1 : Add new ward");
					System.out.println("9 : exit");
					System.out.println("Enter your choice");
					System.out.println();
					int ch;
					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException ime) {
							System.out.println("Enter valid inopt");
							scr.next();
						}
					}

					switch (ch) {

					case 1:

						System.out.println("Enter city name to add ward");
						scr.nextLine();
						String cityName = scr.nextLine();
						int cityId = cityService.getCityidByCityName(cityName);

						System.out.println("Enter Ward name and pin");
						String wardName = scr.nextLine();
						int pin = scr.nextInt();
						wardModel = new WardModel(0, wardName, pin);
						b = wardService.isAddNewWard(wardModel, cityId);
						if (b)
							System.out.println("Ward Added Successfully...");
						else
							System.out.println("Something Wrong");
						break;

					case 9:

						exit = false;

						break;
					}
				} while (exit);// do while
				break;// Case 4 Ward

//Amenities ==================================================================================================
			// this case for all Amenities related services
			case 5:
				exit = true;
				do {
					System.out.println();
					System.out.println("1 : Add new amenity");
					System.out.println("9 : exit");
					System.out.println("Enter your choice");
					int ch;
					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException ime) {
							System.out.println("Please enter a valid input");
							scr.next();
						}
					}
					switch (ch) {
					case 1:
						System.out.println("Enter new Amenity Name");
						scr.nextLine();
						String aminityName = scr.nextLine();
						AminityModel aminityModel = new AminityModel(0, aminityName, 0);
						b = AminityService.isAddNewAminity(aminityModel);
						if (b)
							System.out.println("New Amenity added Succesfully....");
						else
							System.out.println("Something went wrong");

						break;
					case 9:
						exit = false;
						break;
					default:
						System.out.println("Wrong Input");
						break;
					}// switch
				} while (exit); // do while
				break;// case 5 Amenity

//Property =====================================================================================================
			// this case for all property related services
			case 6:
				exit = true;
				boolean response = false;
				do {
					System.out.println();
					System.out.println("1 : Add new Property");
					System.out.println("9 : Exit");
					System.out.println("Enter your choice");
					System.out.println();
					int ch;
					while (true) {
						try {
							ch = scr.nextInt();
							break;
						} catch (InputMismatchException ime) {
							System.out.println("Please enter a valid input");
							scr.next();
						}
					}
					switch (ch) {
					case 1:
						System.out.println();
						List<StateModel> stateList = stateService.getAllStates();
						if (stateList != null) {
							stateList.forEach((s) -> System.out.println(s.getStateId() + "\t" + s.getStateName()));
						} else {
							System.out.println("There is no data");
						}
						System.out.println("Enter state name to add property");
						scr.nextLine();
						String stateName = scr.nextLine();
						List<DistModel> distList = distService.getDistListByStateName(stateName);
						if (distList != null) {
							distList.forEach((d) -> System.out.println(d.getDistId() + "\t" + d.getDistName()));
						} else {
							System.out.println("There is no data");
						}

						System.out.println("Enter Dist name to add property");
						String distName = scr.nextLine();
						List<CityModel> cityList = cityService.getCitiesFromDist(stateName, distName);
						if (cityList != null)
							cityList.forEach((c) -> System.out.println(c.getCityId() + "\t" + c.getCityName()));
						else
							System.out.println("There is no data");

						System.out.println("Enter city name to add property");
						String cityName = scr.nextLine();
						List<WardModel> wardList = wardService.getAllWardByCityName(cityName);
						if (wardList != null)
							wardList.forEach((w) -> System.out.println(w.getWardName()));
						else
							System.out.println("There is no data");
						System.out.println("Enter ward name to get wardid");
						String wardName = scr.nextLine();
						int wardid = wardService.getWardIdByName(wardName);
						System.out.println("Enter property name");
						String pName = scr.nextLine();
						System.out.println("Enter Property Address");
						String pAdd = scr.nextLine();
						System.out.println("Enter Property area in squar feet");
						int areaSF = scr.nextInt();
						System.out.println("Enter property price");
						int pPrice = scr.nextInt();
						wardModel = new WardModel();
						wardModel.setWardId(wardid);
						wardModel.setWardName(wardName);
						System.out.println("--------------------------------");
						System.out.println("Select Aminity");
						List<AminityModel> aminityList = AminityService.getAllAminities();
						aminityList
								.forEach((am) -> System.out.println(am.getAminity_Id() + "\t" + am.getAminity_Name()));
						List<AminityModel> amlist = new ArrayList<AminityModel>();

						do {
							System.out.println("Enter Aminity Name Which you want to purchase");
							scr.nextLine();
							String aminityName = scr.nextLine();
							System.out.println("Do you want add another aminity");
							String res = scr.nextLine();
							AminityModel aminityModel = new AminityModel();
							aminityModel.setAminity_Id(0);
							aminityModel.setAminity_Name(aminityName);
							aminityModel.setPrice(0);
							amlist.add(aminityModel);

							if (res.equals("yes") || res.equals("Yes"))
								response = true;
							else
								response = false;
						} while (response);
						PropertyModel PropModel = new PropertyModel(wardModel, 0, pName, pAdd, pPrice, areaSF, amlist);
						b = propService.isAddNewProperty(PropModel);
						break;
					case 9:
						exit = false;
						break;
					}// switch
				} while (exit);
				break;// Case 6 Property

			case 9:
				scr.close();
				flag = false;
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}// Switch

		} while (flag);// do while
	}// main
}
