package com.techhub.repository;

import java.sql.*;

public class DBstate {
	DBConfig config = DBConfig.getInstance();
	protected Connection conn = config.getConn();
	protected PreparedStatement stmt = config.getStmt();
	protected ResultSet rs = config.getRS();
	protected CallableStatement cstmt = config.getCallStmt();
}
