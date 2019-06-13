package com.generic.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.generic.page.plant;
import com.generic.setup.EnvironmentFiles;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.sql.SqlStatements;

public class sqLiteUtils extends SelTestCase{
	@Test()
	public static void builder() {
		setTestCaseReportName(SheetVariables.DailyReportTestCaseId);
		 createNewDatabase(DatabaseName);
		 createNewTable(TableName, DatabaseName);
//		insertData(23, "tarw", 2, "test.db");
//		selectData("23", "test.db");
//		updateData(23, "tarwqqqqq", 2333, "test.db");
//		selectData("23", "test.db");
	}

	// Create a new database if it doesn't exist, this methods requires the name of
	// the database
	public static void createNewDatabase(String DatabaseName) {
		getCurrentFunctionName(true);
		// Path to the database file
		String url = "jdbc:sqlite:"+EnvironmentFiles.getDatabasePath()+"/" + DatabaseName;
		
		// Make a connection to the specified path, if not exist make a new DB
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				logs.debug("The driver name is " + meta.getDriverName());
				logs.debug("A new database has been created.");
			}
			
			closeConnection(conn);

		} catch (SQLException e) {
			logs.debug(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		getCurrentFunctionName(false);
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logs.debug("connection closed");
				Assert.assertTrue(false, e.getMessage());
			}
		}
	}

	// Creates a new table in a specified database, this method takes the query and
	// the name of the database
	public static void createNewTable(String TableName, String DatabaseName) {
		String url = "jdbc:sqlite:"+EnvironmentFiles.getDatabasePath()+"/" + DatabaseName;
		String querey = SqlStatements.CreateTableStatement.replace("TableName", TableName);
		
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(querey);
			closeConnection(conn);
		} catch (SQLException e) {
			logs.debug("Table is not created" + e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// Inserts data into a specific table, this method requires the data and the
	// name of the database
	public static void insertData(plant plantInfo, String TableName, String DatabaseName) {
		String url = "jdbc:sqlite:" + EnvironmentFiles.getDatabasePath() + "/" + DatabaseName;

		try (Connection conn = DriverManager.getConnection(url)) {
			// Best way to pass the data to the database by passing it as injections
			String Statement = SqlStatements.insertStetment.replace("TableName", TableName)
					+ " VALUES("+plantInfo.PEI_value +","+
					plantInfo.PEI_percentage +","+
					plantInfo.PERF_value +","+
					plantInfo.PERF_percentage +","+
					plantInfo.Avilability_value +","+
					plantInfo.Avilability_percentage +","+
					plantInfo.inverters___Performance +","+
					plantInfo.inverters_Mppt +","+
					plantInfo.inverters_relative_efficiency +","+
					plantInfo.inverters_efficiency_below_spec +","+
					plantInfo.inverters___availability +","+
					plantInfo.inverters___downtime +","+
					plantInfo.strings___performance +","+
					plantInfo.strings___panel_degradation +","+
					plantInfo.strings___disconnected_strings +","+
					plantInfo.strings___availability +","+
					plantInfo.Health_PRpercentage +","+
					plantInfo.Health_PR_STCpercentage +","+
					plantInfo.Health_Data_integrity_percentage +","+
					plantInfo.Health_plantAvilability_percentage +","+
					plantInfo.Health_Power_Factor_percentage +","+
					plantInfo.Healty_Inverters +","+
					plantInfo.Healty_Strings +","+
					plantInfo.OK_Inverters +","+
					plantInfo.OK_Strings +","+
					plantInfo.Faulty_Inverters +","+
					plantInfo.Faulty_Strings +","+
					plantInfo.Messing_data_inverters +","+
					plantInfo.Messing_data_Strings +","+
					plantInfo.Disconnected_Strings_total_devices +","+
					plantInfo.Disconnected_Strings_faulty_devices +","+
					plantInfo.Disconnected_Strings_value +","+
					plantInfo.Disconnected_Strings_percentage +","+
					"'"+plantInfo.Disconnected_Strings_status +"'"+","+
					plantInfo.Panel_Degradation_total_devices +","+
					plantInfo.Panel_Degradation_faulty_devices +","+
					plantInfo.Panel_Degradation_value +","+
					plantInfo.Panel_Degradation_percentage +","+
					"'"+plantInfo.Panel_Degradation_status +"'"+","+
					plantInfo.String_Data_integrity_total_devices +","+
					plantInfo.String_Data_integrity_faulty_devices +","+
					plantInfo.String_Data_integrity_value +","+
					plantInfo.String_Data_integrity_percentage +","+
					"'"+plantInfo.String_Data_integrity_status +"'"+","+
					plantInfo.Temperature_Coefficient_total_devices +","+
					plantInfo.Temperature_Coefficient_faulty_devices +","+
					plantInfo.Temperature_Coefficient_value +","+
					plantInfo.Temperature_Coefficientpercentage +","+
					"'"+plantInfo.Temperature_Coefficient__status +"'"+","+
					plantInfo.Inverter_Downtime_total_devices +","+
					plantInfo.Inverter_Downtime_faulty_devices +","+
					plantInfo.Inverter_Downtime_value +","+
					plantInfo.Inverter_Downtime_percentage +","+
					"'"+plantInfo.Inverter_Downtime__status +"'"+","+
					plantInfo.Inverter_Data_integrity_total_devices +","+
					plantInfo.Inverter_Data_integrity_faulty_devices +","+
					plantInfo.Inverter_Data_integrity_value +","+
					plantInfo.Inverter_Data_integrity_percentage +","+
					"'"+plantInfo.Inverter_Data_integrity_status +"'"+","+
					plantInfo.Inverter_Efficiency_Below_Spec_total_devices +","+
					plantInfo.Inverter_Efficiency_Below_Spec_faulty_devices +","+
					plantInfo.Inverter_Efficiency_Below_Spec_value +","+
					plantInfo.Inverter_Efficiency_Below_Spec_percentage +","+
					"'"+plantInfo.Inverter_Efficiency_Below_Spec_status +"'"+","+
					plantInfo.Late_Awakening_total_devices +","+
					plantInfo.Late_Awakening_faulty_devices +","+
					plantInfo.Late_Awakening_value +","+
					plantInfo.Late_Awakening_percentage +","+
					"'"+plantInfo.Late_Awakening_status +"'"+","+
					plantInfo.Mppt_total_devices +","+
					plantInfo.Mppt_faulty_devices +","+
					plantInfo.Mppt_value +","+
					plantInfo.Mppt_percentage +","+
					"'"+plantInfo.Mppt_status +"'"+","+
					plantInfo.Inverter_Relative_Efficiency_total_devices +","+
					plantInfo.Inverter_Relative_Efficiency_faulty_devices +","+
					plantInfo.Inverter_Relative_Efficiency_value +","+
					plantInfo.Inverter_Relative_Efficiency_percentage +","+
					"'"+plantInfo.Inverter_Relative_Efficiency_status +"'"+","+
					plantInfo.Clipping_total_devices +","+
					plantInfo.Clipping_faulty_devices +","+
					plantInfo.Clipping_value +","+
					plantInfo.Clipping_percentage +","+
					"'"+plantInfo.Clipping_status +"'"+","+
					plantInfo.Power_Factor_total_devices +","+
					plantInfo.Power_Factor_faulty_devices +","+
					plantInfo.Power_Factor_value +","+
					plantInfo.Power_Factor_percentage +","+
					"'"+plantInfo.Power_Factor_status +"'"+","+
					plantInfo.Temperature_Alert_total_devices +","+
					plantInfo.Temperature_Alert_faulty_devices +","+
					plantInfo.Temperature_Alert_value +","+
					plantInfo.Temperature_Alert_percentage +","+
					"'"+plantInfo.Temperature_Alert_status +"'"+","+
					plantInfo.Frequency_Deviation_total_devices +","+
					plantInfo.Frequency_Deviation_faulty_devices +","+
					plantInfo.Frequency_Deviation_value +","+
					plantInfo.Frequency_Deviation_percentage +","+
					"'"+plantInfo.Frequency_Deviation_status +"'"+","+
					plantInfo.Voltage_Deviation_total_devices +","+
					plantInfo.Voltage_Deviation_faulty_devices +","+
					plantInfo.Voltage_Deviation_value +","+
					plantInfo.Voltage_Deviation_percentage +","+
					"'"+plantInfo.Voltage_Deviation_status+"'"+")";
					
			logs.debug(Statement);
			
			PreparedStatement ps = conn.prepareStatement(Statement);
			
			// if it returns less than 0, no rows were inserted
			if (ps.executeUpdate() > 0)
				logs.debug("Inserted sucessfuly");
			else
				logs.debug("Failed to insert");

		} catch (SQLException e) {
			logs.debug(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// This method selects a specific record of data in a specific table,and it
	// requires the database name
	public static void selectData(String id, String fileName) {

		String url = "jdbc:sqlite:"+EnvironmentFiles.getDatabasePath()+"/" + fileName;

		try (Connection conn = DriverManager.getConnection(url);) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM warehouses WHERE id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDouble("capacity"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// Updates data into a specific table, this method requires the data and the
	// name of the database
	public static void updateData(int id, String name, int capacity, String fileName) {
		String url = "jdbc:sqlite:"+EnvironmentFiles.getDatabasePath()+"/" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			// Best way to pass the data to the database by passing it as injections
			PreparedStatement ps = conn.prepareStatement("UPDATE warehouses SET name = ? ,capacity = ? WHERE id = ?");
			ps.setString(1, name);
			ps.setString(2, capacity + "");
			ps.setString(3, id + "");

			// if it returns less than 0, no rows were updated
			if (ps.executeUpdate() > 0)
				System.out.println("Record updated sucessfuly");
			else
				System.out.println("Failed to update record");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}