package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.helper.CSVLoader;

public class Main {

	private static String JDBC_CONNECTION_URL = 
			"jdbc:mysql://localhost:3306/runnergprs?user=root&password=root&database=runnergprs";

	
	public static void main(String[] args) {
		try {
            Connection conn = getCon();
            System.out.println("connection ===>"+conn);
			CSVLoader loader = new CSVLoader(getCon());//E:\\runnerdata\Runner.csv
			loader.loadCSV("D:\\Ver1_3_DistributorMaster.csv", "distributor", true);//true for truncate / false for append
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
