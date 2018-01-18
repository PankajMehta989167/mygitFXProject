package report;

/**
 * @author mohammad.makki
 *
 */
public class ReportBean {
	private String result;
	private String status;
	private String strStartTime;
	private String strEndTime;
	private String strAction;

	public ReportBean(ReportBean clone) {
		this.result = clone.result;
		this.status = clone.status;
		this.strStartTime = clone.strStartTime;
		this.strEndTime = clone.strEndTime;
		this.strAction = clone.strAction;
	}

	public ReportBean() {
		this.result = "";
		this.status = "";
		this.strStartTime = "";
		this.strEndTime = "";
		this.strAction = "";
	}

	/**
	 * @return Getters and Setters
	 */
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStrStartTime() {
		return strStartTime;
	}

	public void setStrStartTime(String strStartTime) {
		this.strStartTime = strStartTime;
	}

	public String getStrEndTime() {
		return strEndTime;
	}

	public void setStrEndTime(String strEndTime) {
		this.strEndTime = strEndTime;
	}

	public String getStrAction() {
		return strAction;
	}

	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}
}
