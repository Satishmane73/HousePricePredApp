package com.techhub.repository;

public class Query {

	// State related Query
	public static String addNewState = "insert into statemaster values('0',?)";

	public static String getAllStates = "select *from statemaster";

	public static String getStateByName = "select *from statemaster where statename=?";

	public static String getStateIdByName = "select stateid from statemaster where statename=?";

	public static String deleteState = "delete from statemaster where stateid=?";

	public static String getStateIdByCityName = "select cdj.stateid from citymaster cm join citydistjoin cdj on cm.cityid = cdj.cityid where cm.cityname = ?";

	// District related Query
	public static String savedist = "{call savedist(?,?)}";

	public static String getDistIdByName = "select distid from distmaster where distname=?";

	public static String getDistByStateName = " select d.distid, d.distname from distmaster d inner join statedistjoin stj on d.distid=stj.distid inner join statemaster sm on sm.stateid=stj.stateid where sm.statename=?;";

	public static String getDistIdByCityName = "select cdj.distid from citymaster cm join citydistjoin cdj on cm.cityid = cdj.cityid where cm.cityname = ?";

	// City Related Query
	public static String saveCity = "{call savecity(?,?,?)}";

	public static String getCityIdByName = "select cm.cityid from citymaster cm inner join citydistjoin cdj on cdj.cityid=cm.cityid where cm.cityname=? and cdj.stateid=? and cdj.distid=?";

	public static String getCityByDistId = "select c.cityname, c.cityid from citymaster c inner join citydistjoin cdj on c.cityid=cdj.cityid inner join distmaster d on d.distid=cdj.distid where cdj.stateid=? and d.distid=?";

	// Ward Related Query
	public static String addNewWard = "{call saveward(?,?,?)}";

	public static String getWardByCityName = "select wm.wardname from wardmaster wm inner join citywardjoin cwj on wm.wardid=cwj.wardid inner join citymaster cm on cm.cityid=cwj.cityid where cm.cityname=?";

	public static String getWardIdByName = "select wardid from wardmaster where wardname=?";

	// Aminity Related Query
	public static String addNewAminity = "insert into aminities values('0',?)";

}
