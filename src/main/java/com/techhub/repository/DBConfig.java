package com.techhub.repository;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class DBConfig {
	protected static Connection conn;
	protected static ResultSet rs;
	protected static PreparedStatement stmt;
	protected static CallableStatement cstmt;
	private static DBConfig db;

	private static Logger loger = Logger.getLogger(DBConfig.class);

	static {
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		loger.addAppender(appender);
	}

	private DBConfig() {
		try {
			File f = new File("");
			String path = f.getAbsolutePath();
			FileInputStream inputStream = new FileInputStream(path + "\\src\\main\\resources\\DBConfig.properties");
			Properties p = new Properties();
			p.load(inputStream);
			String driver = p.getProperty("driver");
			String user = p.getProperty("user");
			String pass = p.getProperty("pass");
			String url = p.getProperty("url");

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, pass);
			if (conn != null)
				loger.info("Database Is Connected");
			else
				loger.info("Databbase Connection Failed");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static DBConfig getInstance() {
		if (db == null)
			db = new DBConfig();
		return db;
	}

	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getStmt() {
		return stmt;
	}

	public static ResultSet getRS() {
		return rs;
	}

	public static CallableStatement getCallStmt() {
		return cstmt;
	}
}
