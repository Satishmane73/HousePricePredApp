package com.techhub.repository;

import java.sql.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.techhub.clientApp.ClientApp;

public class DBState {
	DBConfig config = DBConfig.getInstance();
	protected Connection conn = config.getConn();
	protected PreparedStatement stmt = config.getStmt();
	protected ResultSet rs = config.getRS();
	protected CallableStatement cstmt = config.getCallStmt();

}
