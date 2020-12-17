package com.kishorekumarkorada.IIOTDataVisualizer.web.dto;

public class ProcjessDTO {
	
	private int processId;
	private String processName;
	private String processStartTime;
	private String processEndTime;
	private String processStatus;
	private boolean isProcessFailed;
	private String processFailedReason;
	
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessStartTime() {
		return processStartTime;
	}
	public void setProcessStartTime(String processStartTime) {
		this.processStartTime = processStartTime;
	}
	public String getProcessEndTime() {
		return processEndTime;
	}
	public void setProcessEndTime(String processEndTime) {
		this.processEndTime = processEndTime;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public boolean isProcessFailed() {
		return isProcessFailed;
	}
	public void setProcessFailed(boolean isProcessFailed) {
		this.isProcessFailed = isProcessFailed;
	}
	public String getProcessFailedReason() {
		return processFailedReason;
	}
	public void setProcessFailedReason(String processFailedReason) {
		this.processFailedReason = processFailedReason;
	}
}
