package com.test.designPatterns.responsibilityChain;

public class LeaveRequest {
	private int leaveDay;
	private String leaveReason;
	private String leaveNotes;
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getLeaveNotes() {
		return leaveNotes;
	}
	public void setLeaveNotes(String leaveNotes) {
		this.leaveNotes = leaveNotes;
	}
	
	
}
