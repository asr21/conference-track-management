/**
 * 
 */
package com.example.conferencetrackmanagement.model;

import java.time.LocalTime;

/**
 * @author abhijit
 *
 */
public class Talk implements Comparable<Talk>{

	String talkTitle;
	int durationInMinutes;
	LocalTime startTime;
	LocalTime endTime;
	
	public Talk(String data) {
		String dataArray[] = data.split(" ");
		this.durationInMinutes = parseDuration(dataArray[dataArray.length-1]);
		this.talkTitle = parseTitleFromSplitArray(dataArray);
	}
	
	private String parseTitleFromSplitArray(String[] dataArray) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<dataArray.length-1;i++) {
			stringBuilder.append(dataArray[i]);
			stringBuilder.append(" ");
		}
		return stringBuilder.toString().trim();
	}

	private int parseDuration(String string) {
		if(string.contains("lightning")) {
			return 5;
		} else if(string.contains("min")) {
			int indexOfMin = string.indexOf("min");
			return Integer.parseInt(string.substring(0,indexOfMin));
		} else {
			throw new RuntimeException("input string for time doesnot contain lightning or min");
		}
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
		this.endTime= LocalTime.from(startTime).plusMinutes(durationInMinutes);
	}
	
	public String getTalkTitle() {
		return talkTitle;
	}
	
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "Talk [talkTitle=" + talkTitle + ", durationInMinutes=" + durationInMinutes + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Talk talk) {
		if (durationInMinutes == talk.getDurationInMinutes()) {
			return 0;
		} else if (durationInMinutes > talk.getDurationInMinutes()) {
			return 1;
		} else {
			return -1;
		}
	}
}
