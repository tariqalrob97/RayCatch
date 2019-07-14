package com.generic.sql;

import java.time.LocalDate;

import com.generic.setup.SelTestCase;

public class SqlStatements extends SelTestCase {
	public static String CreateTableStatement = "CREATE TABLE TableName (\r\n"
			+ "RayDate date NOT NULL DEFAULT (datetime('now','localtime')),\r\n"
			+ "user string NOT NULL DEFAULT 'NA',"
			+ "plant string NOT NULL DEFAULT 'NA',"
			+ "PEI_value double NOT NULL DEFAULT 0,\r\n" + "PEI_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "PERF_value double NOT NULL DEFAULT 0,\r\n" + "PERF_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Avilability_value double NOT NULL DEFAULT 0,\r\n"
			+ "Avilability_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Inverters_Performance_Percent double NOT NULL DEFAULT 0,\r\n"
			+ "Strings_Performance_Percent double NOT NULL DEFAULT 0,\r\n"
			+ "inverters___Performance double NOT NULL DEFAULT 0,\r\n" + "inverters_Mppt double NOT NULL DEFAULT 0,\r\n"
			+ "inverters_relative_efficiency double NOT NULL DEFAULT 0,\r\n"
			+ "inverters_efficiency_below_spec double NOT NULL DEFAULT 0,\r\n"
			+ "inverters___availability double NOT NULL DEFAULT 0,\r\n"
			+ "inverters___downtime double NOT NULL DEFAULT 0,\r\n"
			+ "strings___performance double NOT NULL DEFAULT 0,\r\n"
			+ "strings___panel_degradation double NOT NULL DEFAULT 0,\r\n"
			+ "strings___disconnected_strings double NOT NULL DEFAULT 0,\r\n"
			+ "strings___availability double NOT NULL DEFAULT 0,\r\n"
			+ "Health_PRpercentage double NOT NULL DEFAULT 0,\r\n"
			+ "Health_PR_STCpercentage double NOT NULL DEFAULT 0,\r\n"
			+ "Health_Data_integrity_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Health_plantAvilability_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Health_Power_Factor_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Healty_Inverters double NOT NULL DEFAULT 0,\r\n" + "Healty_Strings double NOT NULL DEFAULT 0,\r\n"
			+ "OK_Inverters double NOT NULL DEFAULT 0,\r\n" + "OK_Strings double NOT NULL DEFAULT 0,\r\n"
			+ "Faulty_Inverters double NOT NULL DEFAULT 0,\r\n" + "Faulty_Strings double NOT NULL DEFAULT 0,\r\n"
			+ "Messing_data_inverters double NOT NULL DEFAULT 0,\r\n"
			+ "Messing_data_Strings double NOT NULL DEFAULT 0,\r\n"
			+ "Disconnected_Strings_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Disconnected_Strings_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Disconnected_Strings_value double NOT NULL DEFAULT 0,\r\n"
			+ "Disconnected_Strings_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Disconnected_Strings_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Panel_Degradation_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Panel_Degradation_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Panel_Degradation_value double NOT NULL DEFAULT 0,\r\n"
			+ "Panel_Degradation_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Panel_Degradation_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "String_Data_integrity_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "String_Data_integrity_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "String_Data_integrity_value double NOT NULL DEFAULT 0,\r\n"
			+ "String_Data_integrity_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "String_Data_integrity_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Temperature_Coefficient_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Coefficient_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Coefficient_value double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Coefficientpercentage double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Coefficient__status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Inverter_Downtime_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Downtime_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Downtime_value double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Downtime_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Downtime__status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Inverter_Data_integrity_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Data_integrity_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Data_integrity_value double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Data_integrity_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Data_integrity_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Inverter_Efficiency_Below_Spec_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Efficiency_Below_Spec_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Efficiency_Below_Spec_value double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Efficiency_Below_Spec_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Efficiency_Below_Spec_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Late_Awakening_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Late_Awakening_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Late_Awakening_value double NOT NULL DEFAULT 0,\r\n"
			+ "Late_Awakening_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Late_Awakening_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Mppt_total_devices double NOT NULL DEFAULT 0,\r\n" + "Mppt_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Mppt_value double NOT NULL DEFAULT 0,\r\n" + "Mppt_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Mppt_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Inverter_Relative_Efficiency_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Relative_Efficiency_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Relative_Efficiency_value double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Relative_Efficiency_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Inverter_Relative_Efficiency_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Clipping_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Clipping_faulty_devices double NOT NULL DEFAULT 0,\r\n" + "Clipping_value double NOT NULL DEFAULT 0,\r\n"
			+ "Clipping_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Clipping_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Power_Factor_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Power_Factor_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Power_Factor_value double NOT NULL DEFAULT 0,\r\n"
			+ "Power_Factor_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Power_Factor_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Temperature_Alert_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Alert_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Alert_value double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Alert_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Temperature_Alert_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Frequency_Deviation_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Frequency_Deviation_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Frequency_Deviation_value double NOT NULL DEFAULT 0,\r\n"
			+ "Frequency_Deviation_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Frequency_Deviation_status string NOT NULL DEFAULT 'Healthy',\r\n"
			+ "Voltage_Deviation_total_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Voltage_Deviation_faulty_devices double NOT NULL DEFAULT 0,\r\n"
			+ "Voltage_Deviation_value double NOT NULL DEFAULT 0,\r\n"
			+ "Voltage_Deviation_percentage double NOT NULL DEFAULT 0,\r\n"
			+ "Voltage_Deviation_status string NOT NULL DEFAULT 'Healthy'\r\n" + ");";

	public static String insertStetment = "INSERT INTO TableName (user,plant,PEI_value ,\r\n" + "PEI_percentage ,\r\n" + "PERF_value ,\r\n"
			+ "PERF_percentage ,\r\n" + "Avilability_value ,\r\n" + "Avilability_percentage ,\r\n"+ "Inverters_Performance_Percent ,\r\n"+ "Strings_Performance_Percent ,\r\n"
			+ "inverters___Performance ,\r\n" + "inverters_Mppt ,\r\n" + "inverters_relative_efficiency ,\r\n"
			+ "inverters_efficiency_below_spec ,\r\n" + "inverters___availability ,\r\n" + "inverters___downtime ,\r\n"
			+ "strings___performance ,\r\n" + "strings___panel_degradation ,\r\n"
			+ "strings___disconnected_strings ,\r\n" + "strings___availability ,\r\n" + "Health_PRpercentage ,\r\n"
			+ "Health_PR_STCpercentage ,\r\n" + "Health_Data_integrity_percentage ,\r\n"
			+ "Health_plantAvilability_percentage ,\r\n" + "Health_Power_Factor_percentage ,\r\n"
			+ "Healty_Inverters ,\r\n" + "Healty_Strings ,\r\n" + "OK_Inverters ,\r\n" + "OK_Strings ,\r\n"
			+ "Faulty_Inverters ,\r\n" + "Faulty_Strings ,\r\n" + "Messing_data_inverters ,\r\n"
			+ "Messing_data_Strings ,\r\n" + "Disconnected_Strings_total_devices ,\r\n"
			+ "Disconnected_Strings_faulty_devices ,\r\n" + "Disconnected_Strings_value ,\r\n"
			+ "Disconnected_Strings_percentage ,\r\n" + "Disconnected_Strings_status ,\r\n"
			+ "Panel_Degradation_total_devices ,\r\n" + "Panel_Degradation_faulty_devices ,\r\n"
			+ "Panel_Degradation_value ,\r\n" + "Panel_Degradation_percentage ,\r\n" + "Panel_Degradation_status ,\r\n"
			+ "String_Data_integrity_total_devices ,\r\n" + "String_Data_integrity_faulty_devices ,\r\n"
			+ "String_Data_integrity_value ,\r\n" + "String_Data_integrity_percentage ,\r\n"
			+ "String_Data_integrity_status ,\r\n" + "Temperature_Coefficient_total_devices ,\r\n"
			+ "Temperature_Coefficient_faulty_devices ,\r\n" + "Temperature_Coefficient_value ,\r\n"
			+ "Temperature_Coefficientpercentage ,\r\n" + "Temperature_Coefficient__status ,\r\n"
			+ "Inverter_Downtime_total_devices ,\r\n" + "Inverter_Downtime_faulty_devices ,\r\n"
			+ "Inverter_Downtime_value ,\r\n" + "Inverter_Downtime_percentage ,\r\n" + "Inverter_Downtime__status ,\r\n"
			+ "Inverter_Data_integrity_total_devices ,\r\n" + "Inverter_Data_integrity_faulty_devices ,\r\n"
			+ "Inverter_Data_integrity_value ,\r\n" + "Inverter_Data_integrity_percentage ,\r\n"
			+ "Inverter_Data_integrity_status ,\r\n" + "Inverter_Efficiency_Below_Spec_total_devices ,\r\n"
			+ "Inverter_Efficiency_Below_Spec_faulty_devices ,\r\n" + "Inverter_Efficiency_Below_Spec_value ,\r\n"
			+ "Inverter_Efficiency_Below_Spec_percentage ,\r\n" + "Inverter_Efficiency_Below_Spec_status ,\r\n"
			+ "Late_Awakening_total_devices ,\r\n" + "Late_Awakening_faulty_devices ,\r\n"
			+ "Late_Awakening_value ,\r\n" + "Late_Awakening_percentage ,\r\n" + "Late_Awakening_status ,\r\n"
			+ "Mppt_total_devices ,\r\n" + "Mppt_faulty_devices ,\r\n" + "Mppt_value ,\r\n" + "Mppt_percentage ,\r\n"
			+ "Mppt_status ,\r\n" + "Inverter_Relative_Efficiency_total_devices ,\r\n"
			+ "Inverter_Relative_Efficiency_faulty_devices ,\r\n" + "Inverter_Relative_Efficiency_value ,\r\n"
			+ "Inverter_Relative_Efficiency_percentage ,\r\n" + "Inverter_Relative_Efficiency_status ,\r\n"
			+ "Clipping_total_devices ,\r\n" + "Clipping_faulty_devices ,\r\n" + "Clipping_value ,\r\n"
			+ "Clipping_percentage ,\r\n" + "Clipping_status ,\r\n" + "Power_Factor_total_devices ,\r\n"
			+ "Power_Factor_faulty_devices ,\r\n" + "Power_Factor_value ,\r\n" + "Power_Factor_percentage ,\r\n"
			+ "Power_Factor_status ,\r\n" + "Temperature_Alert_total_devices ,\r\n"
			+ "Temperature_Alert_faulty_devices ,\r\n" + "Temperature_Alert_value ,\r\n"
			+ "Temperature_Alert_percentage ,\r\n" + "Temperature_Alert_status ,\r\n"
			+ "Frequency_Deviation_total_devices ,\r\n" + "Frequency_Deviation_faulty_devices ,\r\n"
			+ "Frequency_Deviation_value ,\r\n" + "Frequency_Deviation_percentage ,\r\n"
			+ "Frequency_Deviation_status ,\r\n" + "Voltage_Deviation_total_devices ,\r\n"
			+ "Voltage_Deviation_faulty_devices ,\r\n" + "Voltage_Deviation_value ,\r\n"
			+ "Voltage_Deviation_percentage ,\r\n" + "Voltage_Deviation_status \r\n" + ")\r\n";
	
	public static String SelectPreviousDate = "SELECT * FROM RayDailyData WHERE strftime('%s', raydate) BETWEEN strftime('%s', '?3') AND strftime('%s', '" + LocalDate.now() + "') and user = '?1' and plant = '?2'  ORDER by rowid DESC";
}
