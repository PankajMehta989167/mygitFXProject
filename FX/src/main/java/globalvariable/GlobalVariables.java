package globalvariable;

import java.util.ArrayList;
import java.util.HashMap;

import report.ReportBean;

/**
 * @author mohammad.makki
 *
 */
public class GlobalVariables {

	private static HashMap<String, String> map = null;
	private static String strResult = "";
	private static String strStatus = "";
	private static ArrayList<ReportBean> reportList = null;
	private static String strStartTime = "";
	private static String strEndTime = "";
	private static String browserName = "";
	private static String testCaseName = "";
	public static HashMap<String, String> getMap() {
		if(null == map){
			map = new HashMap<String, String>();
		}
		return map;
	}
	public static void setMap(HashMap<String, String> map) {
		GlobalVariables.map = map;
	}
	public static String getStrResult() {
		return strResult;
	}
	public static void setStrResult(String strResult) {
		GlobalVariables.strResult = strResult;
	}
	public static String getStrStatus() {
		return strStatus;
	}
	public static void setStrStatus(String strStatus) {
		GlobalVariables.strStatus = strStatus;
	}
	public static ArrayList<ReportBean> getReportList() {
		if(null == reportList)
			reportList = new ArrayList<ReportBean>();
		return reportList;
	}
	public static void setReportList(ArrayList<ReportBean> reportList) {
		GlobalVariables.reportList = reportList;
	}
	public static String getStrStartTime() {
		return strStartTime;
	}
	public static void setStrStartTime(String strStartTime) {
		GlobalVariables.strStartTime = strStartTime;
	}
	public static String getStrEndTime() {
		return strEndTime;
	}
	public static void setStrEndTime(String strEndTime) {
		GlobalVariables.strEndTime = strEndTime;
	}
	public static String getBrowserName() {
		return browserName;
	}
	public static void setBrowserName(String browserName) {
		GlobalVariables.browserName = browserName;
	}
	public static String getTestCaseName() {
		return testCaseName;
	}
	public static void setTestCaseName(String testCaseName) {
		GlobalVariables.testCaseName = testCaseName;
	}
	
}
