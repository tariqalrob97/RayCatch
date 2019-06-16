package com.generic.page;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.XlsUtils;

public class plant extends SelTestCase {

	public String user = "NA";
	public String plant = "NA";
	
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

	// Health
	public double Health_PRpercentage = 0;
	public double Health_PR_STCpercentage = 0;
	public double Health_Data_integrity_percentage = 0;
	public double Health_plantAvilability_percentage = 0;
	public double Health_Power_Factor_percentage = 0;

	// Heat map
	public double Healty_Inverters = 0;
	public double Healty_Strings = 0;
	public double OK_Inverters = 0;
	public double OK_Strings = 0;
	public double Faulty_Inverters = 0;
	public double Faulty_Strings = 0;
	public double Messing_data_inverters = 0;
	public double Messing_data_Strings = 0;

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
	public double Temperature_Coefficientpercentage = 0;
	public String Temperature_Coefficient__status = "Healthy";

	public double Inverter_Downtime_total_devices = 0;
	public double Inverter_Downtime_faulty_devices = 0;
	public double Inverter_Downtime_value = 0;
	public double Inverter_Downtime_percentage = 0;
	public String Inverter_Downtime__status = "Healthy";

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
	public double Mppt_value = 0;
	public double Mppt_percentage = 0;
	public String Mppt_status = "Healthy";

	public double Inverter_Relative_Efficiency_total_devices = 0;
	public double Inverter_Relative_Efficiency_faulty_devices = 0;
	public double Inverter_Relative_Efficiency_value = 0;
	public double Inverter_Relative_Efficiency_percentage = 0;
	public String Inverter_Relative_Efficiency_status = "Healthy";
	
	public double Clipping_total_devices = 0;
	public double Clipping_faulty_devices = 0;
	public double Clipping_value = 0;
	public double Clipping_percentage = 0;
	public String Clipping_status = "Healthy";

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

	public double Voltage_Deviation_total_devices = 0;
	public double Voltage_Deviation_faulty_devices = 0;
	public double Voltage_Deviation_value = 0;
	public double Voltage_Deviation_percentage = 0;
	public String Voltage_Deviation_status = "Healthy";
	
	//RC- ready
	public static void printPlant(plant tmpPlant)
	{
		getCurrentFunctionName(true);
		try {
			logs.debug("user:" + tmpPlant.user);
			logs.debug("plant:" + tmpPlant.plant);
			logs.debug("PEI_value:" + tmpPlant.PEI_value);
			logs.debug("PEI_percentage:" + tmpPlant.PEI_percentage);
			logs.debug("PERF_value:" + tmpPlant.PERF_value);
			logs.debug("PERF_percentage:" + tmpPlant.PERF_percentage);
			logs.debug("Avilability_value:" + tmpPlant.Avilability_value);
			logs.debug("Avilability_percentage:" + tmpPlant.Avilability_percentage);
			logs.debug("inverters___Performance:" + tmpPlant.inverters___Performance);
			logs.debug("inverters_Mppt:" + tmpPlant.inverters_Mppt);
			logs.debug("inverters_relative_efficiency:" + tmpPlant.inverters_relative_efficiency);
			logs.debug("inverters_efficiency_below_spec:" + tmpPlant.inverters_efficiency_below_spec);
			logs.debug("inverters___availability:" + tmpPlant.inverters___availability);
			logs.debug("inverters___downtime:" + tmpPlant.inverters___downtime);
			logs.debug("strings___performance:" + tmpPlant.strings___performance);
			logs.debug("strings___panel_degradation:" + tmpPlant.strings___panel_degradation);
			logs.debug("strings___disconnected_strings:" + tmpPlant.strings___disconnected_strings);
			logs.debug("strings___availability:" + tmpPlant.strings___availability);
			logs.debug("Health_PRpercentage:" + tmpPlant.Health_PRpercentage);
			logs.debug("Health_PR_STCpercentage:" + tmpPlant.Health_PR_STCpercentage);
			logs.debug("Health_Data_integrity_percentage:" + tmpPlant.Health_Data_integrity_percentage);
			logs.debug("Health_plantAvilability_percentage:" + tmpPlant.Health_plantAvilability_percentage);
			logs.debug("Health_Power_Factor_percentage:" + tmpPlant.Health_Power_Factor_percentage);
			logs.debug("Healty_Inverters:" + tmpPlant.Healty_Inverters);
			logs.debug("Healty_Strings:" + tmpPlant.Healty_Strings);
			logs.debug("OK_Inverters:" + tmpPlant.OK_Inverters);
			logs.debug("OK_Strings:" + tmpPlant.OK_Strings);
			logs.debug("Faulty_Inverters:" + tmpPlant.Faulty_Inverters);
			logs.debug("Faulty_Strings:" + tmpPlant.Faulty_Strings);
			logs.debug("Messing_data_inverters:" + tmpPlant.Messing_data_inverters);
			logs.debug("Messing_data_Strings:" + tmpPlant.Messing_data_Strings);
			logs.debug("Disconnected_Strings_total_devices:" + tmpPlant.Disconnected_Strings_total_devices);
			logs.debug("Disconnected_Strings_faulty_devices:" + tmpPlant.Disconnected_Strings_faulty_devices);
			logs.debug("Disconnected_Strings_value:" + tmpPlant.Disconnected_Strings_value);
			logs.debug("Disconnected_Strings_percentage:" + tmpPlant.Disconnected_Strings_percentage);
			logs.debug("Disconnected_Strings_status:" + tmpPlant.Disconnected_Strings_status);
			logs.debug("Panel_Degradation_total_devices:" + tmpPlant.Panel_Degradation_total_devices);
			logs.debug("Panel_Degradation_faulty_devices:" + tmpPlant.Panel_Degradation_faulty_devices);
			logs.debug("Panel_Degradation_value:" + tmpPlant.Panel_Degradation_value);
			logs.debug("Panel_Degradation_percentage:" + tmpPlant.Panel_Degradation_percentage);
			logs.debug("Panel_Degradation_status:" + tmpPlant.Panel_Degradation_status);
			logs.debug("String_Data_integrity_total_devices:" + tmpPlant.String_Data_integrity_total_devices);
			logs.debug("String_Data_integrity_faulty_devices:" + tmpPlant.String_Data_integrity_faulty_devices);
			logs.debug("String_Data_integrity_value:" + tmpPlant.String_Data_integrity_value);
			logs.debug("String_Data_integrity_percentage:" + tmpPlant.String_Data_integrity_percentage);
			logs.debug("String_Data_integrity_status:" + tmpPlant.String_Data_integrity_status);
			logs.debug("Temperature_Coefficient_total_devices:" + tmpPlant.Temperature_Coefficient_total_devices);
			logs.debug("Temperature_Coefficient_faulty_devices:" + tmpPlant.Temperature_Coefficient_faulty_devices);
			logs.debug("Temperature_Coefficient_value:" + tmpPlant.Temperature_Coefficient_value);
			logs.debug("Temperature_Coefficientpercentage:" + tmpPlant.Temperature_Coefficientpercentage);
			logs.debug("Temperature_Coefficient__status:" + tmpPlant.Temperature_Coefficient__status);
			logs.debug("Inverter_Downtime_total_devices:" + tmpPlant.Inverter_Downtime_total_devices);
			logs.debug("Inverter_Downtime_faulty_devices:" + tmpPlant.Inverter_Downtime_faulty_devices);
			logs.debug("Inverter_Downtime_value:" + tmpPlant.Inverter_Downtime_value);
			logs.debug("Inverter_Downtime_percentage:" + tmpPlant.Inverter_Downtime_percentage);
			logs.debug("Inverter_Downtime__status:" + tmpPlant.Inverter_Downtime__status);
			logs.debug("Inverter_Data_integrity_total_devices:" + tmpPlant.Inverter_Data_integrity_total_devices);
			logs.debug("Inverter_Data_integrity_faulty_devices:" + tmpPlant.Inverter_Data_integrity_faulty_devices);
			logs.debug("Inverter_Data_integrity_value:" + tmpPlant.Inverter_Data_integrity_value);
			logs.debug("Inverter_Data_integrity_percentage:" + tmpPlant.Inverter_Data_integrity_percentage);
			logs.debug("Inverter_Data_integrity_status:" + tmpPlant.Inverter_Data_integrity_status);
			logs.debug("Inverter_Efficiency_Below_Spec_total_devices:" + tmpPlant.Inverter_Efficiency_Below_Spec_total_devices);
			logs.debug("Inverter_Efficiency_Below_Spec_faulty_devices:" + tmpPlant.Inverter_Efficiency_Below_Spec_faulty_devices);
			logs.debug("Inverter_Efficiency_Below_Spec_value:" + tmpPlant.Inverter_Efficiency_Below_Spec_value);
			logs.debug("Inverter_Efficiency_Below_Spec_percentage:" + tmpPlant.Inverter_Efficiency_Below_Spec_percentage);
			logs.debug("Inverter_Efficiency_Below_Spec_status:" + tmpPlant.Inverter_Efficiency_Below_Spec_status);
			logs.debug("Late_Awakening_total_devices:" + tmpPlant.Late_Awakening_total_devices);
			logs.debug("Late_Awakening_faulty_devices:" + tmpPlant.Late_Awakening_faulty_devices);
			logs.debug("Late_Awakening_value:" + tmpPlant.Late_Awakening_value);
			logs.debug("Late_Awakening_percentage:" + tmpPlant.Late_Awakening_percentage);
			logs.debug("Late_Awakening_status:" + tmpPlant.Late_Awakening_status);
			logs.debug("Mppt_total_devices:" + tmpPlant.Mppt_total_devices);
			logs.debug("Mppt_faulty_devices:" + tmpPlant.Mppt_faulty_devices);
			logs.debug("Mppt_value:" + tmpPlant.Mppt_value);
			logs.debug("Mppt_percentage:" + tmpPlant.Mppt_percentage);
			logs.debug("Mppt_status:" + tmpPlant.Mppt_status);
			logs.debug("Inverter_Relative_Efficiency_total_devices:" + tmpPlant.Inverter_Relative_Efficiency_total_devices);
			logs.debug("Inverter_Relative_Efficiency_faulty_devices:" + tmpPlant.Inverter_Relative_Efficiency_faulty_devices);
			logs.debug("Inverter_Relative_Efficiency_value:" + tmpPlant.Inverter_Relative_Efficiency_value);
			logs.debug("Inverter_Relative_Efficiency_percentage:" + tmpPlant.Inverter_Relative_Efficiency_percentage);
			logs.debug("Inverter_Relative_Efficiency_status:" + tmpPlant.Inverter_Relative_Efficiency_status);
			logs.debug("Clipping_total_devices:" + tmpPlant.Clipping_total_devices);
			logs.debug("Clipping_faulty_devices:" + tmpPlant.Clipping_faulty_devices);
			logs.debug("Clipping_value:" + tmpPlant.Clipping_value);
			logs.debug("Clipping_percentage:" + tmpPlant.Clipping_percentage);
			logs.debug("Clipping_status:" + tmpPlant.Clipping_status);
			logs.debug("Power_Factor_total_devices:" + tmpPlant.Power_Factor_total_devices);
			logs.debug("Power_Factor_faulty_devices:" + tmpPlant.Power_Factor_faulty_devices);
			logs.debug("Power_Factor_value:" + tmpPlant.Power_Factor_value);
			logs.debug("Power_Factor_percentage:" + tmpPlant.Power_Factor_percentage);
			logs.debug("Power_Factor_status:" + tmpPlant.Power_Factor_status);
			logs.debug("Temperature_Alert_total_devices:" + tmpPlant.Temperature_Alert_total_devices);
			logs.debug("Temperature_Alert_faulty_devices:" + tmpPlant.Temperature_Alert_faulty_devices);
			logs.debug("Temperature_Alert_value:" + tmpPlant.Temperature_Alert_value);
			logs.debug("Temperature_Alert_percentage:" + tmpPlant.Temperature_Alert_percentage);
			logs.debug("Temperature_Alert_status:" + tmpPlant.Temperature_Alert_status);
			logs.debug("Frequency_Deviation_total_devices:" + tmpPlant.Frequency_Deviation_total_devices);
			logs.debug("Frequency_Deviation_faulty_devices:" + tmpPlant.Frequency_Deviation_faulty_devices);
			logs.debug("Frequency_Deviation_value:" + tmpPlant.Frequency_Deviation_value);
			logs.debug("Frequency_Deviation_percentage:" + tmpPlant.Frequency_Deviation_percentage);
			logs.debug("Frequency_Deviation_status:" + tmpPlant.Frequency_Deviation_status);
			logs.debug("Voltage_Deviation_total_devices:" + tmpPlant.Voltage_Deviation_total_devices);
			logs.debug("Voltage_Deviation_faulty_devices:" + tmpPlant.Voltage_Deviation_faulty_devices);
			logs.debug("Voltage_Deviation_value:" + tmpPlant.Voltage_Deviation_value);
			logs.debug("Voltage_Deviation_percentage:" + tmpPlant.Voltage_Deviation_percentage);
			logs.debug("Voltage_Deviation_status:" + tmpPlant.Voltage_Deviation_status);
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
		getCurrentFunctionName(false);
	}//print 

	public static void comparPlantsAndwriteResults(plant tmpPlant, plant previousPlantData) {
		try {
			//set data 
			
			
			
			
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
		getCurrentFunctionName(false);

	}// comparPlants
	
}
