package report;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import globalvariable.GlobalVariables;
import log.Log;

/**
 * @author mohammad.makki
 * Class is for generating Report in HTML format
 *
 */
public class HtmlReport {
	private StringBuffer strBufferReportAppend = null;
	private BufferedWriter bufferedWriter = null;
	private final String reportHeader = "Xerox";
	private BufferedReader bufferedReader = null;

	/**
	 * 
	 */
	public void generateReport() {
		try {
			Log.info("Report is getting generated, Please wait!");
			summaryReport();
			detailReport();
			bufferedWriter.write(strBufferReportAppend.toString());
			bufferedWriter.close();
			Log.info("Report has been generated!");
		} catch (Exception ex) {
			Log.error("Exception occure in generating report." + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 *  Method is for generating the graph and creating the html file
	 */
	public void summaryReport() {

		String strTimeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String reportPath = new File("Report").getAbsolutePath();
		int stepPassed = 0;
		int stepFailed = 0;
		String cssData = "";

		try {
			String cssPath = new File("Report\\Style\\style.css").getAbsolutePath();
			bufferedReader = new BufferedReader(new FileReader(cssPath));

			StringBuilder stringBuilder = new StringBuilder();
			String line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			cssData = stringBuilder.toString();
		} catch (Exception ex) {
			Log.error("Exception occure in reading file" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				Log.error("Exception occure in reading file");
				e.printStackTrace();
			}
		}
		File HTMLDir = new File(reportPath + "\\HTMLReport");
		if (!HTMLDir.exists()) {
			try {
				HTMLDir.mkdir();
			} catch (SecurityException ex) {
				Log.error("Error in creating HTMLReport directory" + ex.getMessage());
				// log.error("Error in creating Detail directory");
			}
		}
		String htmlname = HTMLDir + "\\" + strTimeStamp + ".html";
		String logoPath = new File("Report\\Style\\logo.png").getAbsolutePath();
		for (ReportBean reportValue : GlobalVariables.getReportList()) {
			if (reportValue.getStatus().equalsIgnoreCase("Failed")) {
				stepFailed++;
			} else if (reportValue.getStatus().equalsIgnoreCase("Passed")) {
				stepPassed++;
			}
		}
		strBufferReportAppend = new StringBuffer();
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(htmlname));
		} catch (IOException e) {
			Log.error("Error in wrinting the file" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strBufferReportAppend.append(
				"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
		strBufferReportAppend.append("<script src=\"https://www.google.com/jsapi\"></script>");
		strBufferReportAppend.append("<style>" + cssData);
		strBufferReportAppend.append("</style>");
		strBufferReportAppend.append("</head><body>");
		strBufferReportAppend.append("<table class=\"width100\">");
		strBufferReportAppend.append("<tr><td>");
		strBufferReportAppend.append("<table class=\"width100\">");
		strBufferReportAppend.append("<tr><td><img src=file:\\\\" + logoPath + "></td>" + "<td class=\"headertext\">"
				+ reportHeader + "</td>");

		strBufferReportAppend.append("</tr></table><hr></hr>");
		strBufferReportAppend.append("</td></tr>");
		strBufferReportAppend.append("<tr><td>");
		strBufferReportAppend.append("<table class=\"width100\">");
		strBufferReportAppend.append("<tr><td class=\"width50\">");
		strBufferReportAppend.append("<table cellpadding=3 cellspacing=1>");
		strBufferReportAppend
		.append("<tr><td class=\"width50 bold\">Execution Start Time</td><td class=\"width50 bold\">"
				+ GlobalVariables.getStrStartTime() + "</td></tr>");
		strBufferReportAppend
		.append("<tr><td class=\"width50 bold\">Execution End Time</td><td class=\"width50 bold\">"
				+ GlobalVariables.getStrEndTime() + "</td></tr>");
		strBufferReportAppend
				.append("<tr><td class=\"width50 bold\">Total TestSteps Executed</td><td class=\"width50 bold\">"
						+ (stepFailed + stepPassed) + "</td></tr>");
		strBufferReportAppend.append(
				"<tr><td class=\"width50 green\">Passed</td><td class=\"width50 green\">" + stepPassed + "</td></tr>");
		strBufferReportAppend.append(
				"<tr><td class=\"width50 red\">Failed</td><td class=\"width50 red\">" + stepFailed + "</td></tr>");
		strBufferReportAppend.append("</table></td>");
		strBufferReportAppend.append("<td class=\"width50\">");
		strBufferReportAppend.append("<table>");
		strBufferReportAppend.append("<tr><td class=\"width25\">");
		strBufferReportAppend.append("</td>");
		strBufferReportAppend.append("<td class=\"width25\">");
		strBufferReportAppend.append("<script type=\"text/javascript\">");
		strBufferReportAppend.append("google.charts.load('current', {'packages':['corechart']});");
		strBufferReportAppend.append("google.charts.setOnLoadCallback(drawDetailsChart);");
		strBufferReportAppend.append("function drawDetailsChart() {");
		strBufferReportAppend.append("var data = new google.visualization.DataTable();");
		strBufferReportAppend.append("data.addColumn('string', 'Test Execution Detail Graph');");
		strBufferReportAppend.append("data.addColumn('number', 'Count');");
		strBufferReportAppend.append("data.addRows([");
		strBufferReportAppend.append("['Passed'," + stepPassed + "],");
		strBufferReportAppend.append("['Failed'," + stepFailed + "]]);");
		strBufferReportAppend
				.append("var options = {'title':'Test Step Details Graph',colors: ['#12C909', '#C3100A'],pieHole: 0.3,");
		strBufferReportAppend.append("'width':300,");
		strBufferReportAppend.append("'height':170};");
		strBufferReportAppend
				.append("var chart = new google.visualization.PieChart(document.getElementById('detailsChart_div'));");
		strBufferReportAppend.append("chart.draw(data, options); } </script>");
		strBufferReportAppend.append("<div id=\"detailsChart_div\"></div>");
		strBufferReportAppend.append("</td></tr></table>");
		strBufferReportAppend.append("</td></tr></table><hr></hr></td></tr>");
	}

	/**
	 *  Method is used for printing the values  of test steps 
	 */
	public void detailReport() {
		int testStepId = 1;
		strBufferReportAppend.append(
				"<tr><td><table class=\"width100\"><tr><td><div class=\"headertext1 bold\">Test Execution Detail Report</div></td></tr>");
		strBufferReportAppend.append(
				"<tr><td><div class=\"headertext1 bold\">Execution Browser Name:  "+ GlobalVariables.getBrowserName() + "</div></td></tr>");
		strBufferReportAppend.append(
				"<tr><td><div class=\"headertext1 bold\">Test Case Name:  "+ GlobalVariables.getTestCaseName() + "</div></td></tr>");
		
		
		strBufferReportAppend.append("<tr><td>");
		strBufferReportAppend
				.append("<table colspan=3 border=0 cellpadding=3 cellspacing=1 class=\"reporttable width100\">");
		strBufferReportAppend.append("<tr><th class=\"auto-style1\">Test Step No</th>" + "<th class=\"auto-style2\">Action</th>"
				+ "<th class=\"auto-style3\">Actual Result</th>" + "<th class=\"auto-style4\">Status</th></tr>");
		for (ReportBean reportValue : GlobalVariables.getReportList()) {

			if (reportValue.getStatus().equalsIgnoreCase("Passed")) {

				strBufferReportAppend.append("<tr>" + "<td class=\"auto-style1 blue\">" + testStepId++ + "</td>"// teststepid
						+ "<td class=\"auto-style2 blue\">" + reportValue.getStrAction() + "</td>"
						+ "<td class=\"auto-style3 blue\">" + reportValue.getResult() + "</td>"
						+ "<td class=\"auto-style4 green\">" + reportValue.getStatus() + "</td></tr>");
			} else if (reportValue.getStatus().equalsIgnoreCase("Failed")) {
				strBufferReportAppend.append("<tr>" + "<td class=\"auto-style1 blue\">" + testStepId++ + "</td>"// teststepid
						+ "<td class=\"auto-style2 blue\">" + reportValue.getStrAction() + "</td>"
						+ "<td class=\"auto-style3 blue\">" + reportValue.getResult() + "</td>"
						+ "<td class=\"auto-style4 red\">" + reportValue.getStatus() + "</td></tr>");
			}
		}
		strBufferReportAppend.append("</table>");
		strBufferReportAppend.append("</td></tr>");
		strBufferReportAppend.append("</table></td></tr></table></body></html>");
	}
}
