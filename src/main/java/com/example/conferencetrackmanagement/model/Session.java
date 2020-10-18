/**
 * 
 */
package com.example.conferencetrackmanagement.model;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author abhijit
 */
public class Session implements Comparable<Session>{

	String sessionName;
	LocalTime startTime;
	LocalTime endTime;

	public Session(String sessionName, LocalTime startTime, LocalTime endTime) {
		this.sessionName = sessionName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getSessionName() {
		return sessionName;
	}



	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}



	public LocalTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public long getDurationInMinutes() {
		return Duration.between(startTime, endTime).toMinutes();
	}

	@Override
	public int compareTo(Session o) {
		if (startTime.equals(o.startTime)) {
			return 0;
		} else if (startTime.isAfter(o.startTime)) {
			return 1;
		} else {
			return -1;
		}
	}
}
