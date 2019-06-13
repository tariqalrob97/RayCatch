package com.generic.page;

public class plant {

	// general
	public double PEI_value = 0;
	public double PEI_percentage = 0;
	public double PERF_value = 0;
	public double PERF_percentage = 0;
	public double Avilability_value = 0;
	public double Avilability_percentage = 0;

	// aggregation
	public double inverters___Performance = 0;
	public double inverters_Mppt = 0;
	public double inverters_relative_efficiency = 0;
	public double inverters_efficiency_below_spec = 0;
	public double inverters___availability = 0;
	public double inverters___downtime = 0;
	public double strings___performance = 0;
	public double strings___panel_degradation = 0;
	public double strings___disconnected_strings = 0;
	public double strings___availability = 0;

	// Health  added helth tag
	public double Health_PRpercentage = 0;
	public double Health_PR_STCpercentage = 0;
	public double Health_Data_integrity_percentage = 0;
	public double Health_plantAvilability_percentage = 0;
	public double Health_Power_Factor_percentage = 0;

	// insight
	public double Disconnected_Strings_total_devices = 0;
	public double Disconnected_Strings_faulty_devices = 0;
	public double Disconnected_Strings_value = 0;
	public double Disconnected_Strings_percentage = 0;
	public String Disconnected_Strings_status = "Healthy";

	public double Panel_Degradation_total_devices = 0;
	public double Panel_Degradation_faulty_devices = 0;
	public double Panel_Degradation_value = 0;
	public double Panel_Degradation_percentage = 0;
	public String Panel_Degradation_status = "Healthy";
	
	public double String_Data_integrity_total_devices = 0;
	public double String_Data_integrity_faulty_devices = 0;
	public double String_Data_integrity_value = 0;
	public double String_Data_integrity_percentage = 0;
	public String String_Data_integrity_status = "Healthy";
	
	public double Temperature_Coefficient_total_devices = 0;
	public double Temperature_Coefficient_faulty_devices = 0;
	public double Temperature_Coefficient_value = 0;
	public double Temperature_Coefficient_percentage = 0;
	public String Temperature_Coefficient_status = "Healthy";

	public double Inverter_Downtime_total_devices = 0;
	public double Inverter_Downtime_faulty_devices = 0;
	public double Inverter_Downtime_value = 0;
	public double Inverter_Downtime_percentage = 0;
	public String Inverter_Downtime_status = "Healthy";

	public double Inverter_Data_integrity_total_devices = 0;
	public double Inverter_Data_integrity_faulty_devices = 0;
	public double Inverter_Data_integrity_value = 0;
	public double Inverter_Data_integrity_percentage = 0;
	public String Inverter_Data_integrity_status = "Healthy";

	public double Inverter_Efficiency_Below_Spec_total_devices = 0;
	public double Inverter_Efficiency_Below_Spec_faulty_devices = 0;
	public double Inverter_Efficiency_Below_Spec_value = 0;
	public double Inverter_Efficiency_Below_Spec_percentage = 0;
	public String Inverter_Efficiency_Below_Spec_status = "Healthy";
	

	public double Late_Awakening_total_devices = 0;
	public double Late_Awakening_faulty_devices = 0;
	public double Late_Awakening_value = 0;
	public double Late_Awakening_percentage = 0;
	public String Late_Awakening_status = "Healthy";

	public double Mppt_total_devices = 0;
	public double Mppt_faulty_devices = 0;
	public double Mppt_value = 0;               //remove late
	public double Mppt_percentage = 0;			//remove late
	public String Mpptc_status = "Healthy";

	public double Inverter_Relative_Efficiency_total_devices = 0;
	public double Inverter_Relative_Efficiency_faulty_devices = 0;
	public double Inverter_Relative_Efficiency_value = 0; // Remove late
	public double Inverter_Relative_Efficiency_percentage = 0;
	public String Inverter_Relative_Efficiency_status = "Healthy";

	public double Clipping_total_devices = 0;
	public double Clipping_faulty_devices = 0;
	public double Clipping_value = 0;
	public double Clipping_percentage = 0;   // was wrong
	public String Clipping_percentage_status = "Healthy";

	public double Power_Factor_total_devices = 0;
	public double Power_Factor_faulty_devices = 0;
	public double Power_Factor_value = 0;
	public double Power_Factor_percentage = 0;
	public String Power_Factor_status = "Healthy";


	public double Temperature_Alert_total_devices = 0;
	public double Temperature_Alert_faulty_devices = 0;
	public double Temperature_Alert_value = 0;
	public double Temperature_Alert_percentage = 0;
	public String Temperature_Alert_status = "Healthy";

	public double Frequency_Deviation_total_devices = 0;
	public double Frequency_Deviation_faulty_devices = 0;
	public double Frequency_Deviation_value = 0;
	public double Frequency_Deviation_percentage = 0;
	public String Frequency_Deviation_status = "Healthy";
	
	//was messing
	public double Voltage_Deviation_total_devices = 0;
	public double Voltage_Deviation_faulty_devices = 0;
	public double Voltage_Deviation_value = 0;
	public double Voltage_Deviation_percentage = 0;
	public String Voltage_Deviationn_status = "Healthy";

	
	
}
